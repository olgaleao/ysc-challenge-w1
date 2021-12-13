(ns ysc-challenge-w1.core
  (:use clojure.pprint)
  (:require [datomic.api :as d]
            [ysc-challenge-w1.db :as db]
            [ysc-challenge-w1.model :as y.model]
            [ysc-challenge-w1.client :as y.client]
            [ysc-challenge-w1.card :as y.card]
            [ysc-challenge-w1.transactions :as y.transactions]))

(def conn (db/open-connection!))

(db/set-schema! conn)

(def client-1 (y.client/new-client (y.model/uuid) "Elisa Soares" "elisa.soares@email.com" "12345678900"))
(def clients [client-1])
(db/add-clients! conn clients)

(def card-1 (y.card/new-card (y.model/uuid) "1111222233334444" "123" "06/2024" 500000))
(def cards [card-1])
(db/add-cards! conn cards)

(def transaction-1 (y.transactions/new-transaction! (y.model/uuid) "01/06/2021" 1000 "Parquinho" "Lazer"))
(def transaction-2 (y.transactions/new-transaction! (y.model/uuid) "12/06/2021" 75000 "Loja de Roupas" "Vestimenta"))
(def transaction-3 (y.transactions/new-transaction! (y.model/uuid) "01/06/2021" 7000 "Supermercado" "Alimentacao"))
(def transaction-4 (y.transactions/new-transaction! (y.model/uuid) "01/06/2021" 9800 "Restaurante" "Alimentacao"))
(def transactions [transaction-1 transaction-2 transaction-3 transaction-4])
(db/add-transactions! conn transactions)

(pprint (db/transactions! (d/db conn)))

;(db/delete-db!)