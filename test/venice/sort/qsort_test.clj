(ns venice.sort.qsort-test
  (:require [clojure.test :refer :all]
            [venice.sort.base-sort-test :refer :all]
            [venice.sort.qsort :refer :all]))

(deftest simple-sorting
  (test-with-different-numeric-values qsort))

(deftest empty-list
  (test-with-empty-list qsort))
