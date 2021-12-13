(ns ysc-challenge-w1.client
  (:require [schema.core :as s]
            [ysc-challenge-w1.model :as y.model]))

(s/set-fn-validation! true)

(def Cpf #"\d{11}")

(s/defn new-client
  [uuid :- s/Uuid
   name :- s/Str
   email :- s/Str
   cpf :- Cpf]
  {:client/id    uuid
   :client/name  name
   :client/email email
   :client/cpf   cpf})