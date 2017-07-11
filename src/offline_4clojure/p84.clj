;; Transitive Closure - Hard
;; Write a function which generates the <a href="http://en.wikipedia.org/wiki/Transitive_closure">transitive closure</a> of a <a href="http://en.wikipedia.org/wiki/Binary_relation">binary relation</a>.  The relation will be represented as a set of 2 item vectors.
;; tags - set-theory
;; restricted -
(ns offline-4clojure.p84
  (:use clojure.test))

(def __
  (fn transitive
    ([tuples]
     (let [graph (->> tuples seq flatten (apply hash-map))]
          (println "graph:" graph)
          (transitive graph nil)))
    ([graph x]
     (reduce (fn [agg [k v :as e]]
                (if (contains? agg v)
                    (let [g (conj agg [k (get agg v)])]
                      (println g "," k "," (get agg v))
                      (transitive g g))
                    agg))
             graph graph))))

(defn -main []
  (are [soln] soln
    (let [divides #{[8 4] [9 3] [4 2] [27 9]}]
      (= (__ divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))
    (let [more-legs
          #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
      (= (__ more-legs)
         #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
           ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))
    (let [progeny
          #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
      (= (__ progeny)
         #{["father" "son"] ["father" "grandson"]
           ["uncle" "cousin"] ["son" "grandson"]}))))
