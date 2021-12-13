(ns ysc-challenge-w1.core
  (:use clojure.pprint)
  (:require [datomic.api :as d]
            [ysc-challenge-w1.db :as db]
            [ysc-challenge-w1.client :as y.client]
            [ysc-challenge-w1.card :as y.card]
            [ysc-challenge-w1.transactions :as y.transactions]))

(def conn (db/open-connection!))

(db/set-schema! conn)

(def client-1 (y.client/new-client ("Elisa Soares" "elisa.soares@email.com" "12345678900")))
(def clients [client-1])
(db/add-clients! conn clients)

(def card-1 (y.card/new-card ("1111222233334444" "123" "06/2024" 500000)))
(def cards [card-1])
(db/add-cards! conn cards)

(def transaction-1 (y.transactions/new-transaction! ("01/06/2021" 1000 "Parquinho" "Alimentacao")))
(def transactions [transaction-1])
(db/add-transactions! conn transactions)