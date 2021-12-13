(ns ysc-challenge-w1.card
  (:require [schema.core :as s]
            [ysc-challenge-w1.model :as y.model]))

(s/set-fn-validation! true)

(def CardNumber #"\d{16}")
(def Cvv #"\d{3}")
(def Expiration-Date #"\d{2}/\d{4}")

(s/defn new-card
  [number :- CardNumber
   cvv :- Cvv
   expiration-date :- Expiration-Date
   limit :- y.model/PosInt]
  {:card/card-number     number
   :card/cvv             cvv
   :card/expiration-date expiration-date
   :card/limit           limit})