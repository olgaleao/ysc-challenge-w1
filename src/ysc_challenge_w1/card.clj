(ns ysc-challenge-w1.card
  (:require [schema.core :as s]
            [ysc-challenge-w1.model :as y.model]))

(s/set-fn-validation! true)

(def CardNumber #"\d{16}")
(def Cvv #"\d{3}")
(def Expiration-Date #"\{2}/\{4}")
(def Card {:id y.model/PosInt
           :client-id y.model/PosInt
           :number CardNumber
           :cvv Cvv
           :expiration-date Expiration-Date
           :limit y.model/PosInt})
(def Cards [Card])

(def card-1 {:id              01
             :client-id       01
             :number          "1111222233334444"
             :cvv             123
             :expiration-date "06/2024"
             :limit           500000})

(s/defn cards :- Cards
  []
  [card-1])

(s/defn add-cards :- Cards
  [card :- Card]
  (def cards (conj cards card))
  cards)


(s/defn new-card :- Card
  [id :- y.model/PosInt
   client-id :- y.model/PosInt
   number :- CardNumber
   cvv :- Cvv
   expiration-date :- Expiration-Date
   limit :- y.model/PosInt]
  {:id              id
   :client-id       client-id
   :number          number
   :cvv             cvv
   :expiration-date expiration-date
   :limit           limit})
