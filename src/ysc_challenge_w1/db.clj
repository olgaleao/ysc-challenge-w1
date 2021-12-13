(ns ysc-challenge-w1.db
  (:require [datomic.api :as d]))

(def db-uri "datomic:dev://localhost:4334/credit-card")

(defn open-connection! []
  (d/create-database db-uri)
  (d/connect db-uri))

(defn delete-db! []
  (d/delete-database db-uri))

(def schema [{:db/ident       :card/card-number
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Card number with 16 digits"}
             {:db/ident       :card/cvv
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "CVV with 3 digits"}
             {:db/ident       :card/expiration-date
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Expiration date (mm/YYYY)"}
             {:db/ident       :card/limit
              :db/valueType   :db.type/bigint
              :db/cardinality :db.cardinality/one
              :db/doc         "Card limit (in cents)"}

             {:db/ident       :client/name
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Client's name"}
             {:db/ident       :client/email
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Client's email"}
             {:db/ident       :client/cpf
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Client's cpf (11 digits)"}])

(defn set-schema! [conn]
  (d/transact conn schema))



;TO-DO definir as funcoes de adicionar no banco etc etc etc