(ns ysc-challenge-w1.credit-card-bill
  (:require [schema.core :as s]
            [ysc-challenge-w1.model :as y.model]
            [ysc-challenge-w1.transactions :as y.transactions]))

(s/set-fn-validation! true)

(def transactions (y.transactions/list-transactions))

(defn transaction-amount
  [transaction]
  (get transaction :amount 0))

(s/defn credit-card-bill :- y.model/PosInt
  [transactions :- y.transactions/Transactions]
  (reduce + (map transaction-amount transactions)))

(println "Fatura total:" (credit-card-bill transactions))