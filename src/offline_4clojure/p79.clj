;; Triangle Minimal Path - Hard
;; Write a function which calculates the sum of the minimal path through a triangle.  The triangle is represented as a collection of vectors.  The path should start at the top of the triangle and move to an adjacent number on the next row until the bottom of the triangle is reached.
;; tags - graph-theory
;; restricted - 
(ns offline-4clojure.p79
  (:use clojure.test))

(def __
  (fn min-path
    ([tri] (min-path tri 0 0))
    ([tri sum x] 
      ;;(println "sum:" sum "x:" x)
      (if (empty? tri)
        sum
        (let [v (-> tri first (get x))
              s2 (+ sum v)
              l (min-path (rest tri) s2 x)
              r (min-path (rest tri) s2 (inc x))]
          ;;(println "v:" v "s2:" "l:" l "r:" r)
          (min l r))))))

(defn -main []
  (are [soln] soln
    (= 7 (__ '([1]
              [2 4]
             [5 1 4]
            [2 3 4 5]))) ; 1->2->1->3
    (= 20 (__ '([3]
               [2 4]
              [1 9 3]
              [9 9 2 4]
             [4 6 6 7 8]
            [5 7 3 5 1 4]))) ; 3->4->3->2->7->1
))
