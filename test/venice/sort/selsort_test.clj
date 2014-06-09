(ns venice.sort.selsort-test
  (:require [clojure.test :refer :all]
            [venice.sort.selsort :refer :all]))

(deftest simple-sorting
  (is (= [-5 -2 1 5 7] (selsort [7 1 -5 -2 5])))
  (is (= [-10 -9 0 1 29] (selsort [29 0 1 -9 -10])))
  (is (= [1 2 3] (selsort [1 2 3])))
  (is (= [2 2 2] (selsort [2 2 2]))))

(deftest empty-list
  (is (= [] (selsort []))))
