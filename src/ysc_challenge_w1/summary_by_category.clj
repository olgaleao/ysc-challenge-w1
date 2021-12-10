(ns ysc-challenge-w1.summary-by-category
  (:use clojure.pprint)
  (:require [ysc-challenge-w1.transactions :as y.transactions]
            [ysc-challenge-w1.model :as y.model]
            [schema.core :as s]))

(s/set-fn-validation! true)

(def Summary [{:category s/Str
               :amount   y.model/PosInt}])

(def transactions (y.transactions/list-transactions))

(defn amount-by-category
  [[category category-transactions]]
  {:category category
   :amount   (reduce + (map :amount category-transactions))})

(s/defn summary-by-category :- Summary
  [transactions :- y.transactions/Transactions]
  (->> transactions
       (group-by :category)
       (map amount-by-category)))

(pprint (summary-by-category transactions))