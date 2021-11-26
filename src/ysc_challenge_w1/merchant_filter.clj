(ns ysc-challenge-w1.merchant-filter
  (:require [ysc-challenge-w1.transactions :as y.transactions]))

(def transactions (y.transactions/transactions))

(defn merchant-filter [transaction merchant-input]
  (let [merchant (get transaction :merchant 0)]
    (when (= merchant merchant-input)
      (println transaction))))

(println "Filtro por estabelecimento:")
(filter #(merchant-filter % "Loja de Roupas") transactions)