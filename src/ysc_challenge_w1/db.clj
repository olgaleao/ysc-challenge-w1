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
              :db/valueType   :db.type/long
              :db/cardinality :db.cardinality/one
              :db/doc         "Card limit (cents)"}

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
              :db/doc         "Client's cpf (11 digits)"}

             {:db/ident       :transaction/id
              :db/valueType   :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/unique      :db.unique/identity}
             {:db/ident       :transaction/date
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Transaction date (DD/mm/YYY)"}
             {:db/ident       :transaction/amount
              :db/valueType   :db.type/long
              :db/cardinality :db.cardinality/one
              :db/doc         "Transaction amaount (cents)"}
             {:db/ident       :transaction/merchant
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Transaction merchant"}
             {:db/ident       :transaction/category
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Transaction category"}])

(defn set-schema! [conn]
  (d/transact conn schema))

(defn add-clients! [conn client-list]
  (d/transact conn client-list))

(defn add-cards! [conn card-list]
  (d/transact conn card-list))

(defn add-transactions! [conn transaction-list]
  (d/transact conn transaction-list))

(defn transactions! [db]
  (d/q '[:find (pull ?entity [*])
         :where [?entity :transaction/id]], db))