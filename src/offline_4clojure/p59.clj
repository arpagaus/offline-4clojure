;; Juxtaposition - Medium
;; Take a set of functions and return a new function that takes a variable number of arguments and returns a sequence containing the result of applying each function left-to-right to the argument list.
;; tags - higher-order-functions:core-functions
;; restricted - juxt
(ns offline-4clojure.p59
  (:use clojure.test))

(defn __
  ([f] f)
  ([f g] (fn [& xs] [(apply f xs) (apply g xs)]))
  ([f g & gs] (fn [& xs] (reduce #(conj %1 (apply %2 xs)) [] (list* f g gs))))
)

(defn -main []
  (are [soln] soln
(= [21 6 1] ((__ + max min) 2 3 5 1 6 4))
(= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello"))
(= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))
))
