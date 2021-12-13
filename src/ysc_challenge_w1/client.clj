(ns ysc-challenge-w1.client
  (:require [schema.core :as s]
            [ysc-challenge-w1.model :as y.model]))

(s/set-fn-validation! true)

(def Cpf #"\d{11}")

(s/defn new-client
  [name :- s/Str
   email :- s/Str
   cpf :- Cpf]
  {:client/name  name
   :client/email email
   :client/cpf   cpf})