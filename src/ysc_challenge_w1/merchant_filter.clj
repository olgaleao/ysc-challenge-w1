(ns ysc-challenge-w1.merchant-filter
  (:require [schema.core :as s]
            [ysc-challenge-w1.transactions :as y.transactions]))

(s/set-fn-validation! true)

(def transactions (y.transactions/list-transactions))

(s/defn merchant-filter
  [transaction :- y.transactions/Transaction
   merchant-input :- s/Str]
  (let [merchant (get transaction :merchant 0)]
    (when (= merchant merchant-input)
      (println transaction))))

(println "Filtro por estabelecimento:")
(filter #(merchant-filter % "Loja de Roupas") transactions)