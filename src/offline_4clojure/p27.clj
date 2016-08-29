;; Palindrome Detector - Easy
;; Write a function which returns true if the given sequence is a palindrome.<br/><br>
;;                Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p27
  (:use clojure.test))

(def __
  #(let [size (count %)
       split (partition (unchecked-int (/ size 2)) (unchecked-int (/ (inc size) 2)) %)
       a (first split)
       b (reverse (last split))]
   (= a b))
)

(defn -main []
  (are [soln] soln
(false? (__ '(1 2 3 4 5)))
(true? (__ "racecar"))
(true? (__ [:foo :bar :foo]))
(true? (__ '(1 1 3 3 1 1)))
(false? (__ '(:a :b :c)))
))
