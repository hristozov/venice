(ns venice.ds.bin-heap-test
  (:require [clojure.test :refer :all]
            [venice.ds.bin-heap :refer :all]))

(deftest heap-empty?-test
  (is (true? (heap-empty? (empty-heap))))
  (is (false? (heap-empty? (heapify [1 2 3])))))

(deftest empty-heap-test
  (is (= [] (empty-heap))))

(deftest one-element-heap-test
  (is (= [1] (insert (empty-heap) 1))))

(deftest two-element-heap-test
  (is (= [2 3] (insert 
                 (insert (empty-heap) 3)
                 2)))
  (is (= [3 3] (insert 
                 (insert (empty-heap) 3)
                 3)))
  (is (= [3 4] (insert 
                 (insert (empty-heap) 3)
                 4))))

(deftest heapify-test
  (is (= [] (heapify [])))
  (is (= [1] (heapify [1])))
  (is (= [2 3] (heapify [2 3])))
  (is (= [2 3] (heapify [3 2])))
  (is (= [2 3 4] (heapify [3 2 4])))
  (is (= [2 3 4] (heapify [2 3 4])))
  (is (= [2 4 3] (heapify [4 2 3])))
  (is (= [2 4 3] (heapify [4 3 2])))
  (is (= [2 2 2] (heapify [2 2 2])))
  (is (= [-5 0 0 0 0 0 0 0 0 0] (heapify [0 0 0 0 0 -5 0 0 0 0])))
  (is (= [-5 0 0 0 0 0 0 0 0 0] (heapify [-5 0 0 0 0 0 0 0 0 0])))
  (is (= [-5 0 0 0 0 0 0 0 0 0] (heapify [0 0 0 0 0 0 0 0 0 -5])))
  (is (= [-5 -5 0 0 0 0 0 0 0 0] (heapify [0 0 0 0 0 -5 0 0 0 -5]))))

(deftest min-element-test
  (is (= 1 (min-element (heapify [1]))))
  (is (= 1 (min-element (heapify [1 2]))))
  (is (= 1 (min-element (heapify [2 1]))))
  (is (= 1 (min-element (heapify [1 7 3]))))
  (is (= 1 (min-element (heapify [7 1 3]))))
  (is (= 1 (min-element (heapify [7 3 1]))))
  (is (= 1 (min-element (heapify [7 3 1 4 2 8 9]))))
  (is (= 1 (min-element (heapify [7 3 2 4 1 8 9]))))
  (is (= 1 (min-element (heapify [7 3 2 4 9 8 1]))))
  (is (= 1 (min-element (heapify [1 3 2 4 9 8 7]))))
  (is (= 0 (min-element (heapify [0 7 3 1 7 1 0 25 4 2 8 9 0]))))
  (is (= -5 (min-element (heapify [0 0 -5 25 4 2 8 9 0]))))
  (is (= -5 (min-element (heapify [0 0 -5 25 26 -4 -3 -2 2 8 9 0]))))
  (is (= -5 (min-element (heapify [0 0 0 0 0 0 -5 0 0 0 0 -5])))))

; TODO: Fix the composition ugliness here...
(deftest delete-min-test
  (is (= [] (delete-min (empty-heap))))
  (is (= [] (delete-min (heapify []))))
  (is (= 2 ((comp min-element delete-min heapify) [1 2 3])))
  (is (= 2 ((comp min-element delete-min heapify) [2 1 3])))
  (is (= 2 ((comp min-element delete-min heapify) [2 3 1])))
  (is (= 0 ((comp min-element delete-min heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0])))
  (is (= 0 ((comp min-element (apply comp (repeat 2 delete-min)) heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0])))
  (is (= 1 ((comp min-element (apply comp (repeat 3 delete-min)) heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0])))
  (is (= 1 ((comp min-element (apply comp (repeat 4 delete-min)) heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0])))
  (is (= 2 ((comp min-element (apply comp (repeat 5 delete-min)) heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0])))
  (is (= 3 ((comp min-element (apply comp (repeat 6 delete-min)) heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0])))
  (is (= 4 ((comp min-element (apply comp (repeat 7 delete-min)) heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0])))
  (is (= 7 ((comp min-element (apply comp (repeat 8 delete-min)) heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0])))
  (is (= 7 ((comp min-element (apply comp (repeat 9 delete-min)) heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0])))
  (is (= 8 ((comp min-element (apply comp (repeat 10 delete-min)) heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0])))
  (is (= 9 ((comp min-element (apply comp (repeat 11 delete-min)) heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0])))
  (is (= 25 ((comp min-element (apply comp (repeat 12 delete-min)) heapify) [0 7 3 1 7 1 0 25 4 2 8 9 0]))))