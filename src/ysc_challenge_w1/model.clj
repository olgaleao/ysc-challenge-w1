(ns ysc-challenge-w1.model
  (:require [schema.core :as s]
            [java-time :as j-time]))

(def PosInt (s/pred pos-int? 'positive-integer))