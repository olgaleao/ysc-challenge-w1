(ns ysc-challenge-w1.amount-filter
  (:require [ysc-challenge-w1.transactions :as y.transactions]))

(def transactions (y.transactions/transactions))

(defn amount-filter [transaction amount-input]
  (let [amount (get transaction :amount 0)]
    (when (= amount amount-input)
      (println transaction))))

(println "Filtro por quantia:")
(filter #(amount-filter % 1000) transactions)