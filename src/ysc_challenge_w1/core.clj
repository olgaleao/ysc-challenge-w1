(ns ysc-challenge-w1.core
  (:use clojure.pprint)
  (:require [datomic.api :as d]
            [ysc-challenge-w1.db :as db]
            [ysc-challenge-w1.client :as y.client]
            [ysc-challenge-w1.card :as y.card]))

(def client-1 (y.client/new-client ("Elisa Soares" "elisa.soares@email.com" "12345678900")))
(d/transact conn [client-1])

(def card-1 (y.card/new-card ("1111222233334444" "123" "06/2024" 500000)))
(d/transact conn [card-1])


