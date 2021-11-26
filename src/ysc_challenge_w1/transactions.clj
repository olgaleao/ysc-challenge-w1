(ns ysc-challenge-w1.transactions)

(def transaction-1 {:id       :transaction-1
                    :date     "12/07/2020"
                    :amount   1000
                    :merchant "Parquinho"
                    :category "Alimentacao"})

(def transaction-2 {:id       :transaction-2
                    :date     "13/06/2020"
                    :amount   25000
                    :merchant "Loja de Roupas"
                    :category "Vestiario"})

(def transaction-3 {:id       :transaction-3
                    :date     "12/08/2020"
                    :amount   2500
                    :merchant "Farmácia Sul"
                    :category "Saude"})

(def transaction-4 {:id       :transaction-4
                    :date     "12/10/2020"
                    :amount   3000
                    :merchant "Restaurante do Tio"
                    :category "Alimentacao"})

(def transaction-5 {:id       :transaction-5
                    :date     "12/10/2020"
                    :amount   4000
                    :merchant "Parquinho"
                    :category "Lazer"})

(defn transactions []
  [transaction-1 transaction-2 transaction-3 transaction-4 transaction-5])