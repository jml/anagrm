(ns anagrm.core
  (:gen-class))

(defn anagram? [x y]
  "Is x an anagram of y?"
  (= (sort x) (sort y)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
