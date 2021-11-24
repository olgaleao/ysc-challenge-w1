(ns ysc-challenge-w1.transactions)

;TO-DO: trocar a chave 'estabelecimento'

(def transaction-1 {:date            "12/06/2020"
                    :price           100
                    :estabelecimento "Restaurante do Zezin"
                    :category        "Alimentacao"})

(def transaction-2 {:date            "12/06/2020"
                    :price           2500
                    :estabelecimento "Loja de Roupas"
                    :category        "Vestiario"})

(def transaction-3 {:date            "12/06/2020"
                    :price           250
                    :estabelecimento "Farmácia Sul"
                    :category        "Saude"})

(def transaction-4 {:date            "12/06/2020"
                    :price           300
                    :estabelecimento "Restaurante do Tio"
                    :category        "Alimentacao"})

(defn transactions []
  [transaction-1 transaction-2 transaction-3 transaction-4])