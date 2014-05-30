(ns venice.search.bin-test
  (:require [clojure.test :refer :all]
            [venice.search.bin :refer :all]))

(deftest bin-search-even-number
  (let [items [1 2 2 4 5 6 7 8]]
    (is (true? (bin items 1)))
    (is (true? (bin items 2)))
    (is (true? (bin items 4)))
    (is (true? (bin items 5)))
    (is (true? (bin items 6)))
    (is (true? (bin items 7)))
    (is (true? (bin items 8)))
    (is (false? (bin items 0)))
    (is (false? (bin items 9)))))

(deftest bin-search-odd-number
  (let [items [-1 2 2 2 11]]
    (is (true? (bin items -1)))
    (is (true? (bin items 2)))
    (is (true? (bin items 11)))
    (is (false? (bin items -5)))
    (is (false? (bin items 15)))))

(deftest bin-search-with-empty-list
  (is (false? (bin [] 0))))

