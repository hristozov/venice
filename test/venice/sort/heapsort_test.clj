(ns venice.sort.heapsort-test
  (:require [clojure.test :refer :all]
            [venice.sort.base-sort-test :refer :all]
            [venice.sort.heapsort :refer :all]))

(deftest simple-sorting
  (test-with-different-numeric-values heapsort))

(deftest empty-list
  (test-with-empty-list heapsort))
