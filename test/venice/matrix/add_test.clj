(ns venice.matrix.add-test
  (:require [clojure.test :refer :all]
            [venice.matrix.add :refer :all]))

(deftest test-a-simple-case
  (let [matrix1 [[1 2 3]
                 [3 2 1]
                 [2 1 3]]
        matrix2 [[4 5 6]
                 [6 5 4]
                 [4 6 5]]
        expected [[5 7 9]
                  [9 7 5]
                  [6 7 8]]]
    (is (= expected (add matrix1 matrix2)))))

(deftest test-with-empty-matrices
    (is (= [] (add [] []))))
