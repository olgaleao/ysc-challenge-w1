(ns ysc-challenge-w1.client-db)

(def client-1 {:id :client-1
               :name "Elisa Soares"
               :email "elisa.soares@email.com"
               :cpf 12345678900})

(defn clients []
  [client-1])