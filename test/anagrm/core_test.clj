(ns anagrm.core-test
  (:use clojure.test
        anagrm.core))

(deftest test-anagram-of-self
  (is (anagram? "jabberwocky" "jabberwocky"))
  (is (anagram? "jabberwocky" "ykcowrebbaj"))
  (is (not (anagram? "cabbage" "brillig"))))
