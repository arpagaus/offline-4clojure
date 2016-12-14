;; Merge with a Function - Medium
;; Write a function which takes a function f and a variable number of maps.  Your function should return a map that consists of the rest of the maps conj-ed onto the first.  If a key occurs in more than one map, the mapping(s) from the latter (left-to-right) should be combined with the mapping in the result by calling (f val-in-result val-in-latter)
;; tags - core-functions
;; restricted - merge-with
(ns offline-4clojure.p69
    (:use clojure.test))

(def __
  (fn
    [f x & xs]
    (let [fn1 (fn [m e]
                (let [v2 (val e)
                      k (key e)
                      v1 (get m k)
                      vnew (if (and v1 v2) (f v1 v2) (or v1 v2))]
                  (assoc m k vnew)))
          
          fn2 (fn
                [m1 m2]
                (reduce fn1 m1 (seq m2)))]
      (reduce fn2 x xs))))

(defn -main []
  (are [soln] soln
    (= (__ * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
       {:a 4, :b 6, :c 20})
    (= (__ - {1 10, 2 20} {1 3, 2 10, 3 15})
       {1 7, 2 10, 3 15})
    (= (__ concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
       {:a [3 4 5], :b [6 7], :c [8 9]})))
