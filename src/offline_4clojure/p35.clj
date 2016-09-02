;; Local bindings - Elementary
;; Clojure lets you give local names to values using the special let-form.
;; tags - syntax
;; restricted - 
(ns offline-4clojure.p35
  (:use clojure.test))

(def __
;; your solution here
)

(defn -main []
  (are [soln] soln
(= 7 (let [x 5] (+ 2 x)))
(= 7 (let [x 3, y 10] (- y x)))
(= 7 (let [x 21] (let [y 3] (/ x y))))
))
