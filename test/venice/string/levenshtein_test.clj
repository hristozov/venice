(ns venice.string.levenshtein-test
  (:require [clojure.test :refer :all]
            [venice.string.levenshtein :refer :all]))

(deftest bobi-bozi
    (is (= 1 (levenshtein "bobi" "bozi"))))

(deftest pesho-petar
    (is (= 3 (levenshtein "Pesho" "Petar"))))

(deftest alphabet
  (is (= 0 (levenshtein "aaabdc" "aaabdc")))
  (is (= 1 (levenshtein "aaabdc" "aaabdx")))
  (is (= 2 (levenshtein "aaabdc" "aaabxy")))
  (is (= 3 (levenshtein "aaabdc" "aaaxyz")))
  (is (= 4 (levenshtein "aaabdc" "abdacc")))
  (is (= 5 (levenshtein "aaabdc" "axyzwv"))))