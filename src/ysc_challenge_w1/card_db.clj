(ns ysc-challenge-w1.card-db)

; TO-DO: verificar se existe um símbolo tipo data
; TO-DO: qual será o valor dos id

(def card-1 {:id               :card-1
             :client-id        :client-1
             :card-information {:number          1111222233334444
                                :cvv             123
                                :expiration-date "06/2024"
                                :limit           500000}})

(defn cards []
  [card-1])