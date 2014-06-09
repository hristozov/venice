(ns venice.gen.sieve-test
  (:require [clojure.test :refer :all]
            [venice.gen.sieve :refer :all]))

(deftest sieve-members
  (let [members (sieve)]
    (is (= [2 3 5 7 11 13 17 19 23 29] (take 10 members)))))
