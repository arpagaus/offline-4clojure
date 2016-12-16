;; Word Sorting - Medium
;; Write a function that splits a sentence up into a sorted list of words.  Capitalization should not affect sort order and punctuation should be ignored.
;; tags - sorting
;; restricted - 
(ns offline-4clojure.p70
  (:use clojure.test)
  (:require [clojure.string :as str]))

(def __
  (fn [s]
    (sort #(compare (str/lower-case %1) (str/lower-case %2)) (str/split s #"[^a-zA-Z]"))))

(def -main []
  (are [soln] soln
    (= (__  "Have a nice day.")
       ["a" "day" "Have" "nice"])
    (= (__  "Clojure is a fun language!")
       ["a" "Clojure" "fun" "is" "language"])
    (= (__  "Fools fall for foolish follies.")
       ["fall" "follies" "foolish" "Fools" "for"])))
