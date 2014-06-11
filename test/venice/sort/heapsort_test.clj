(ns venice.sort.heapsort-test
  (:require [clojure.test :refer :all]
            [venice.sort.heapsort :refer :all]))

(deftest simple-sorting
  (is (= [-5 -2 1 5 7] (heapsort [7 1 -5 -2 5])))
  (is (= [-10 -9 0 1 29] (heapsort [29 0 1 -9 -10])))
  (is (= [1 2 3] (heapsort [1 2 3]))))

(deftest empty-list
  (is (= [] (heapsort []))))
