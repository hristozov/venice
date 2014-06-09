(ns venice.sort.qsort-test
  (:require [clojure.test :refer :all]
            [venice.sort.qsort :refer :all]))

(deftest simple-sorting
  (is (= [-5 -2 1 5 7] (qsort [7 1 -5 -2 5])))
  (is (= [-10 -9 0 1 29] (qsort [29 0 1 -9 -10])))
  (is (= [1 2 3] (qsort [1 2 3]))))

(deftest empty-list
  (is (= []) (qsort [])))
