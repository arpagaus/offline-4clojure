;; Anagram Finder - Medium
;; Write a function which finds all the anagrams in a vector of words.  A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y.  Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other.  Each sub-set should have at least two words.  Words without any anagrams should not be included in the result.
;; tags - 
;; restricted - 
(ns offline-4clojure.p77
  (:use clojure.test))

(def __
  (fn [coll]
    (let [anagram (fn [s1 s2]
                    (= (sort s1) (sort s2)))]
      (clojure.set/select
       #(> (count %1) 1)
       (reduce
        (fn [x y]
          (->> coll
               (filter (partial anagram y))
               set
               (conj x)))
        #{}
        coll)))))

(defn -main []
  (are [soln] soln
    (= (__ ["meat" "mat" "team" "mate" "eat"])
       #{#{"meat" "team" "mate"}})
    (= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
       #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})))
