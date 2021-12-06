(ns ysc-challenge-w1.transactions
  (:require [schema.core :as s]
            [ysc-challenge-w1.model :as y.model]))

(s/set-fn-validation! true)

(def transaction-1 {:id       1
                    :date     "2021-02-01T13:11:32"
                    :amount   1000
                    :merchant "Parquinho"
                    :category "Alimentacao"})

(def transaction-2 {:id       2
                    :date     "2021-06-13T13:11:32"
                    :amount   25000
                    :merchant "Loja de Roupas"
                    :category "Vestiario"})

(def transaction-3 {:id       3
                    :date     "2021-08-01T13:11:32"
                    :amount   2500
                    :merchant "Farmácia Sul"
                    :category "Saude"})

(def transaction-4 {:id       4
                    :date     "2021-10-01T13:11:32"
                    :amount   3000
                    :merchant "Restaurante do Tio"
                    :category "Alimentacao"})

(def transaction-5 {:id       5
                    :date     "2021-12-01T13:11:32"
                    :amount   4000
                    :merchant "Parquinho"
                    :category "Lazer"})

(s/defn transactions :- y.model/Transactions
  []
  [transaction-1 transaction-2 transaction-3 transaction-4 transaction-5])