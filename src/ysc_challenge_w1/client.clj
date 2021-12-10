(ns ysc-challenge-w1.client
  (:require [schema.core :as s]
            [ysc-challenge-w1.model :as y.model]))

(s/set-fn-validation! true)

(def Cpf #"\d{11}")
(def Client {:id    y.model/PosInt
             :name  s/Str
             :email s/Str
             :cpf   Cpf})
(def Clients [Client])

(def client-1 {:id    01
               :name  "Elisa Soares"
               :email "elisa.soares@email.com"
               :cpf   "12345678900"})

(s/defn clients :- Clients []
  [client-1])

(s/defn add-clients :- Clients
  [client :- Client]
  (def clients (conj clients client))
  clients)

(s/defn new-client :- Client
  [id :- y.model/PosInt
   name :- s/Str
   email :- s/Str
   cpf :- Cpf]
  {:id    id
   :name  name
   :email email
   :cpf   cpf})