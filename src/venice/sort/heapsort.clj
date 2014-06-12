(ns venice.sort.heapsort
  (:require [venice.ds.bin-heap :refer :all])
  (:gen-class))

(defn heapsort
  "Performs a heapsort on a list."
  [l]
  (loop [heap (heapify l)
         result []]
    (if (heap-empty? heap)
      result
      (recur (delete-min heap) (conj result (min-element heap))))))
