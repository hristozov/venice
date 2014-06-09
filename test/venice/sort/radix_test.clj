(ns venice.sort.radix-test
  (:require [clojure.test :refer :all]
            [venice.sort.radix :refer :all]))

(deftest simple-sorting
  (is (= [0 1 2 2 7 8 8 9 14 24 31 57] (radix [8 57 1 0 2 24 31 14 8 7 2 9])))
  (is (= [0 1 23 29 41 46 89 159 444 1500 2031] (radix [29 0 1 46 1500 2031 159 444 23 41 89])))
  (is (= [1 2 3] (radix [1 2 3])))
  (is (= [2 2 2] (radix [2 2 2]))))

(deftest empty-list
  (is (= [] (radix []))))
