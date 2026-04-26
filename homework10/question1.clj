;; Noah Thompson
;; 26 April 2026
;; question1.clj

;; getting command line argument
(def arg (Integer/parseInt (first *command-line-args*)))

;; function that squares numbers
(defn square [x] (* x x))

;; range of numbers 1 - n
(def ran (range 1 (+ arg 1)))

;; use map to generate square of numbers
(doseq [x (map square ran)]
    (printf "%d\n" x))

;; using reduce to get the sum
(def sum (reduce + (map square ran)))
(printf "Sum = %d\n" sum)
