(ns anagrm.core-test
  (:use clojure.test
        anagrm.core))

(deftest test-anagram-of-self
  (is (anagram? "jabberwocky" "jabberwocky"))
  (is (anagram? "jabberwocky" "ykcowrebbaj"))
  (is (not (anagram? "cabbage" "brillig"))))

(deftest test-subanagram
  (are [x y] (sub-anagram? x y)
       "jabberwocky" "jabberwocky"
       "jabberwocky" "JABBERWOCKY"
       "JABBERWOCKY" "jabberwocky"
       "jabberwocky" "jabber"
       "specific"    "pie"
       "specific"    "piscie"
       ))

(deftest test-subanagram-of-containing-word
  (is (not (sub-anagram? "jabber" "jabberwocky"))))

(deftest test-subfrequency
  (are [x y] (sub-frequency? x y)
       {:a 2 :b 3 :c 4} {:a 1 :b 1 :c 1}
       {} {}
       {:a 2 :b 3 :c 4} {:a 2 :b 3 :c 4}
       {:a 2 :b 3 :c 4} {:a 2}
       ))

(deftest test-not-subfrequency
  (are [x y] (not (sub-frequency? x y))
       {:a 2 :b 3 :c 4} {:a 2 :b 5 :c 4}
       {:a 2 :b 3 :c 4} {:a 2 :b 3 :c 4 :d 3}
       {:a 2 :b 3 :c 4} {:a 2 :b 3 :d 3}))
