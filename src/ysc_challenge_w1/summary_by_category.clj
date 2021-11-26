(ns ysc-challenge-w1.summary-by-category
  (:require [ysc-challenge-w1.transactions :as y.transactions]))

(def transactions (y.transactions/transactions))

(defn transaction-amount
  [transaction]
  (get transaction :amount 0))


(defn amount-by-category [[category category-transactions]]
  {:category category
   :amount   (reduce + (map transaction-amount category-transactions))})


(defn summary-by-category [transactions]
  (->> transactions
       (group-by :category)
       (map amount-by-category)
       (map vals)))


(println "Resumo por categoria:" (summary-by-category transactions))
