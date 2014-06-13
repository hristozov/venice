(ns venice.sort.radix-test
  (:require [clojure.test :refer :all]
            [venice.sort.base-sort-test :refer :all]
            [venice.sort.radix :refer :all]))

(deftest simple-sorting-default-base
  (test-with-different-numeric-values radix))

(deftest simple-sorting-base-2
  (test-with-different-numeric-values #(radix % 2)))

(deftest simple-sorting-base-10
  (test-with-different-numeric-values #(radix % 10)))

(deftest simple-sorting-base-16
  (test-with-different-numeric-values #(radix % 16)))

(deftest simple-sorting-base-50
  (test-with-different-numeric-values #(radix % 50)))

(deftest simple-sorting-base-100
  (test-with-different-numeric-values #(radix % 100)))

(deftest empty-list
  (test-with-empty-list radix))
