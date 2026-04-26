;; Noah Thompson
;; 26 April 2026
;; question2.clj

;; create a taxation namespace
(ns taxation)

;; tax function
(defn tax [amount rate]
    ;; amount * (rate / 100) to get as a percent
    (* amount (/ rate 100.0))
)

;; calling tax function from application namespace
(ns application)
(def amount 117)
(def rate 7)

;; only wanted 2 decimal places, printing out but calling from taxation namespace
(println (format "Tax for this product is $%.2f" (taxation/tax amount rate)))