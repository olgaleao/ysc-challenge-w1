(ns ysc-challenge-w1.credit-card-bill
  (:require [ysc-challenge-w1.transactions :as y.transactions]))

(def transactions (y.transactions/transactions))

(defn transaction-amount
  [transaction]
  (get transaction :amount 0))

(defn credit-card-bill [transactions]
  (reduce + (map transaction-amount transactions)))

(println "Fatura total:" (credit-card-bill transactions))