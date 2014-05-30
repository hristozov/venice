(ns venice.matrix.mul-test
  (:require [clojure.test :refer :all]
            [venice.matrix.mul :refer :all]))

(deftest bin-search-even-number
 (let [matrix1 [[1 2 3 4]
                [3 2 1 7]
                [2 1 3 5]]
       matrix2 [[4 5 6]
                [6 5 4]
                [4 6 5]
                [1 7 4]]
       expected [[32 61 45]
                 [35 80 59]
                 [31 68 51]]]
    (is (= expected (mul matrix1 matrix2)))))
