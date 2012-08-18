(ns anagrm.core
  (:gen-class))

(use '[clojure.java.io :only (reader)])

(def ^:const DICTIONARY-FILE "/usr/share/dict/words")

(defn anagram? [x y]
  "Is x an anagram of y?"
  (= (sort x) (sort y)))

(defn sub-frequency? [a b]
  (every? #(>= (get a (key %) -1) (val %)) b))

(defn sub-anagram? [base-word sub-word]
  (sub-frequency? (frequencies base-word) (frequencies sub-word)))

(defn find-anagrams [base-word word-list]
  (filter (partial anagram? base-word) word-list))

(defn word-search [search?]
  (with-open [dict (reader DICTIONARY-FILE)]
    (doseq [word (filter search? (line-seq dict))]
      (println word))))

;; XXX - add something to make sure words are of a certain length
;; XXX - add a thing for guaranteeing they contain a certain letter
;; XXX - case insensitive matching
;; XXX - it's a little slow

(defn -main
  "Print the anagrams for a given word"
  [base-word & args]
  (word-search (partial sub-anagram? base-word)))

