(ns venice.sort.selsort-test
  (:require [clojure.test :refer :all]
            [venice.sort.base-sort-test :refer :all]
            [venice.sort.selsort :refer :all]))

(deftest simple-sorting
  (test-with-different-numeric-values selsort))

(deftest empty-list
  (test-with-empty-list selsort))
