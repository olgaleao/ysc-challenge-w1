(ns ysc-challenge-w1.model
  (:require [schema.core :as s]
            [java-time :as j-time]))

(def PosInt (s/pred pos-int? 'positive-integer))
(defn validate-date [date] (j-time/local-date-time? (j-time/local-date-time date)))