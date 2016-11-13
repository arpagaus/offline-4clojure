;; Function Composition - Medium
;; Write a function which allows you to create function compositions.  The parameter list should take a variable number of functions, and create a function applies them from right-to-left.
;; tags - higher-order-functions:core-functions
;; restricted - comp
(ns offline-4clojure.p58
  (:use clojure.test))

(def __
  (fn mycomp
    ([f] f)
    ([f g]
     (fn
       ([] (f (g)))
       ([x] (f (g x)))
       ([x & xs] (f (apply g x xs)))))
    ([f g & fs]
     (reduce mycomp (list* f g fs)))))

(defn -main []
  (are [soln] soln
    (= [3 2 1] ((__ rest reverse) [1 2 3 4]))
    (= 5 ((__ (partial + 3) second) [1 2 3 4]))
    (= true ((__ zero? #(mod % 8) +) 3 5 7 9))
    (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))
