(ns venice.gen.fib-test
  (:require [clojure.test :refer :all]
            [venice.gen.fib :refer :all]))

(deftest fib-members
  (let [members (fib)]
    (is (= 0( nth members 0)))
    (is (= 1 (nth members 1)))
    (is (= 1 (nth members 2)))
    (is (= 8 (nth members 6)))
    (is (= 987 (nth members 16)))))

