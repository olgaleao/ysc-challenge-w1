(ns ysc-challenge-w1.summary-by-category
  (:use clojure.pprint)
  (:require [ysc-challenge-w1.transactions :as y.transactions]
            [ysc-challenge-w1.model :as y.model]
            [schema.core :as s]))

(s/set-fn-validation! true)

(def transactions (y.transactions/transactions))

(s/defn transaction-amount
  [transaction :- y.model/Transaction]
  (get transaction :amount 0))

(defn amount-by-category
  [[category category-transactions]]
  {:category category
   :amount   (reduce + (map transaction-amount category-transactions))})

(s/defn summary-by-category
  [transactions :- y.model/Transactions]
  (->> transactions
       (group-by :category)
       (map amount-by-category)))

(pprint (summary-by-category transactions))