;; Prime Numbers - Medium
;; Write a function which returns the first x
;;number of prime numbers.
;; tags - primes
;; restricted - 
(ns offline-4clojure.p67
  (:use clojure.test))

(def __
  (fn [x] (take x (filter
                   (fn [x] (not (some #(not (ratio? (/ x %1))) (range 2 x))))
                   (range 2 1000)))))

(defn -main []
  (are [soln] soln
    (= (__ 2) [2 3])
    (= (__ 5) [2 3 5 7 11])
    (= (last (__ 100)) 541)))
