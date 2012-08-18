(ns anagrm.core
  (:gen-class))

(use '[clojure.java.io :only (reader)])

(def ^:const DICTIONARY-FILE "/usr/share/dict/words")

(defn anagram? [x y]
  "Is x an anagram of y?"
  (= (sort x) (sort y)))

(defn find-anagrams [base-word word-list]
  (filter (partial anagram? base-word) word-list))

(defn -main
  "Print the anagrams for a given word"
  [base-word & args]
  (with-open [dict (reader DICTIONARY-FILE)]
    (doseq [word (find-anagrams base-word (line-seq dict))]
      (println word))))
