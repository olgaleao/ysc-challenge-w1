(ns ysc-challenge-w1.logic
  (:require [ysc-challenge-w1.transactions :as y.transactions]))

(def transactions (y.transactions/transactions))

(defn transaction-amount
  [transaction]
  (get transaction :amount 0))

(defn amount-by-category [[category details]]
  {:category category
   :amount (reduce + (map transaction-amount details))})

(defn summary-by-category [transactions]
  (->> transactions
       (group-by :category)
       (map amount-by-category)
       (map vals)))

(defn credit-card-bill [transactions]
  (reduce + (map transaction-amount transactions)))

(println (summary-by-category transactions))
(println (credit-card-bill transactions))

(println "\n\n")

(defn funcao [transaction]
  (let [merchant (get transaction :merchant 0)]
    (if (= merchant "Parquinho")
      transaction)))


(println (map funcao transactions))