(ns ysc-challenge-w1.transactions
  (:require [schema.core :as s]
            [ysc-challenge-w1.model :as y.model]))

(s/set-fn-validation! true)

(def Date #"\d{2}/\d{2}/\d{4}")

(def Transaction
  {:id       y.model/PosInt
   :date     Date
   :amount   y.model/PosInt
   :merchant s/Str
   :category s/Str})

(def Transactions
  [Transaction])

(def transaction-1 {:id       1
                    :date     "01/06/2021"
                    :amount   1000
                    :merchant "Parquinho"
                    :category "Alimentacao"})

(def transaction-2 {:id       2
                    :date     "01/06/2021"
                    :amount   25000
                    :merchant "Loja de Roupas"
                    :category "Vestiario"})

(def transaction-3 {:id       3
                    :date     "01/06/2021"
                    :amount   2500
                    :merchant "Farmácia Sul"
                    :category "Saude"})

(def transaction-4 {:id       4
                    :date     "01/06/2021"
                    :amount   3000
                    :merchant "Restaurante do Tio"
                    :category "Alimentacao"})

(def transaction-5 {:id       5
                    :date     "01/06/2021"
                    :amount   4000
                    :merchant "Loja de Roupas"
                    :category "Lazer"})

(def transactions [transaction-1 transaction-2 transaction-3 transaction-4 transaction-5])

(s/defn list-transactions :- Transactions []
  transactions)

(s/defn add-transactions :- Transactions
  [transaction :- Transaction]
  (def transactions (conj transactions transaction))
  (list-transactions))