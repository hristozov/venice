(ns venice.matrix.sub-test
  (:require [clojure.test :refer :all]
            [venice.matrix.sub :refer :all]))

(deftest test-a-simple-case
  (let [matrix1 [[8 4 9]
                 [3 7 2]
                 [9 4 6]]
        matrix2 [[4 5 6]
                 [6 5 4]
                 [4 6 5]]
        expected [[4 -1 3]
                  [-3 2 -2]
                  [5 -2 1]]]
    (is (= expected (sub matrix1 matrix2)))))
