;; Noah Thompson
;; 26 April 2026
;; question3.clj

;; importing the clojure string namespace as str
(require '[clojure.string :as str])

;; parse into rows using slurp to read temperatures.txt
(def rows (str/split (slurp "temperatures.txt") #"\n"))

;; conversion function
(defn convert [x]
    (* (- x 32) (/ 5.0 9))
)

;; map to floating point numbers
(def rows (map (fn [x] (Float/parseFloat x)) rows))

;; applying conversion function
(def rows (map convert rows))

;; printing metrics
(defn average [x]
    (double (/ (reduce + x) (count x))))
(println "min = " (apply min rows))
(println "max = " (apply max rows))
(println "average = " (average rows))