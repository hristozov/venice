(ns venice.sort.bubble-test
  (:require [clojure.test :refer :all]
            [venice.sort.bubble :refer :all]))

(deftest simple-sorting
  (is (= [-5 -2 1 5 7] (bubble [7 1 -5 -2 5])))
  (is (= [-10 -9 0 1 29] (bubble [29 0 1 -9 -10])))
  (is (= [1 2 3] (bubble [1 2 3]))))

(deftest empty-list
  (is (= []) (bubble [])))

