(ns anagrm.core
  (:gen-class)
  (:require [clojure.java.io :refer (reader)]
            [clojure.string :refer (lower-case)]))

(defonce ^:const dictionary-file "/usr/share/dict/words")

(defn anagram?
  "Is x an anagram of y?"
  [x y]
  (= (sort x) (sort y)))

(defn sub-frequency? [a b]
  (every? #(>= (get a (key %) -1) (val %)) b))

(defn sub-anagram? [base-word sub-word]
  (sub-frequency? (frequencies (lower-case base-word)) (frequencies (lower-case sub-word))))

(defn find-anagrams [base-word word-list]
  (filter (partial anagram? base-word) word-list))

(defn word-search [search?]
  (with-open [dict (reader dictionary-file)]
    (doseq [word (filter search? (line-seq dict))]
      (println word))))

(defn smh-target-puzzle
  [letters compulsory-letter min-length]
  #(and (>= (count %)
            min-length)
        (contains? (set %) compulsory-letter)
        (sub-anagram? letters %)))

;; XXX - it's a little slow

(defn -main
  "Print the anagrams for a given word"
  [base-word compulsory-letter & args]
  (word-search (smh-target-puzzle base-word (first compulsory-letter)
                                  4)))

