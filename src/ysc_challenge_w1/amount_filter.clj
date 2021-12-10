(ns ysc-challenge-w1.amount-filter
  (:require [schema.core :as s]
            [ysc-challenge-w1.transactions :as y.transactions]
            [ysc-challenge-w1.model :as y.model]))

(s/set-fn-validation! true)

(def transactions (y.transactions/list-transactions))

(s/defn amount-filter
  [transaction :- y.transactions/Transaction
   amount-input :- y.model/PosInt]
  (let [amount (get transaction :amount 0)]
    (when (= amount amount-input)
      (println transaction))))

(println "Filtro por quantia:")
(filter #(amount-filter % 1000) transactions)