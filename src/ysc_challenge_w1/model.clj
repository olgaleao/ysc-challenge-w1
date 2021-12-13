(ns ysc-challenge-w1.model
  (:require [schema.core :as s]))

(def PosInt (s/pred pos-int? 'positive-integer))

(defn uuid [] (java.util.UUID/randomUUID))