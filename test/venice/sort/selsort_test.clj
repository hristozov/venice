(ns venice.sort.selsort-test
  (:require [clojure.test :refer :all]
            [venice.sort.selsort :refer :all]))

(deftest test-1
  (testing "selsort"
    (is (= [-5 -2 1 5 7] (selsort [7 1 -5 -2 5])))))
