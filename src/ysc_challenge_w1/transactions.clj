(ns ysc-challenge-w1.transactions
  (:use clojure.pprint)
  (:require [schema.core :as s]
            [ysc-challenge-w1.model :as y.model]))

(s/set-fn-validation! true)
(def Date #"\d{2}/\d{2}/\d{4}")

(s/defn new-transaction!
  [date :- Date
   amount :- y.model/PosInt
   merchant :- s/Str
   category :- s/Str]
  {:transaction/date     date
   :transaction/amount   amount
   :transaction/merchant merchant
   :transaction/category category})