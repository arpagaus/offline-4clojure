  ;; Power Set - Medium
  ;; Write a function which generates the <a href="http://en.wikipedia.org/wiki/Power_set">power set</a> of a given set.  The power set of a set x is the set of all subsets of x, including the empty set and x itself.
  ;; tags - set-theory
  ;; restricted -
  (ns offline-4clojure.p85
    (:use clojure.test))

(def __
  (fn superset
    ([s] (superset s #{}))
    ([s acc]
     (if (contains? acc s)
       acc
       (if (empty? s)
         (conj acc s)
         (reduce (fn [acc e] (superset (disj s e) acc))
                 (conj acc s)
                 s))))))

(defn -main []
  (are [soln] soln
    (= (__ #{}) #{#{}})
    (= (__ #{1}) #{#{} #{1}})
    (= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})
    (= (__ #{1 2 3})
       #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})
    (time (= (count (__ (into #{} (range 10)))) 1024))))
