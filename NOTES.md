# Learning Clojure

* What's `(:gen-class)`?
* How do I read from a file?
* How do I define a constant?
* Command-line parsing library? clojure.tools [[thanks Bronsa!]]
  https://github.com/clojure/tools.cli
* Is there a convention for naming constants?


    (use '[clojure.java.io :only (reader)])

    (defn print-if-contains [line word]
      (when (.contains line word) (println line)))

    (let [file "story.txt"
          word "fur"]

    ; with-open will close the reader after
    ; evaluating all the expressions in its body.
    (with-open [rdr (reader file)]
      (doseq [line (line-seq rdr)] (print-if-contains line word))))
