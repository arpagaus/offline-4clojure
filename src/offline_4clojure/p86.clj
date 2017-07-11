;; Happy numbers - Medium
;; Happy numbers are positive integers that follow a particular formula: take each individual digit, square it, and then sum the squares to get a new number. Repeat with the new number and eventually, you might get to a number whose squared sum is 1. This is a happy number. An unhappy number (or sad number) is one that loops endlessly. Write a function that determines if a number is happy or not.
;; tags - math
;; restricted -
(ns offline-4clojure.p86
  (:use [clojure.test]))

(defn __
    [x]
    (let
      [nextval
       (fn [n]
         (->> (str n)
           (map #(- (unchecked-int %) (unchecked-int \0)))
           (map biginteger)
           (map #(.pow % (biginteger 2)))
           (reduce +)))]
      (loop [n x
             acc #{}]
        (println n acc)
        (if (= 1 n) true
          (if (contains? acc n) false
            (recur (nextval n) (conj acc n)))))))

(defn -main []
  (are [soln] soln
   (= (__ 7) true)
   (= (__ 986543210) true)
   (= (__ 2) false)
   (= (__ 3) false)))
