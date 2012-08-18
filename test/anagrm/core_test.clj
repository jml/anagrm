(ns anagrm.core-test
  (:use clojure.test
        anagrm.core))

(deftest test-anagram-of-self
  (is (anagram? "jabberwocky" "jabberwocky")))

(deftest test-anagram-of-palindrome
  (is (anagram? "jabberwocky" "ykcowrebbaj")))

(deftest test-not-actually-anagram
  (is (not (anagram? "cabbage" "brillig"))))
