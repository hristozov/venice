(ns venice.sort.bubble-test
  (:require [clojure.test :refer :all]
            [venice.sort.base-sort-test :refer :all]
            [venice.sort.bubble :refer :all]))

(deftest simple-sorting
  (test-with-different-numeric-values bubble))

(deftest empty-list
  (test-with-empty-list bubble))
