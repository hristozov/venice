(ns venice.ds.bin-heap
  (:gen-class))

(defn- swap [v i1 i2] 
  (assoc v i2 (v i1) i1 (v i2)))

(defn- parent-idx
  [index]
  (int (Math/floor (/ (- index 1) 2))))

(defn- left-child-idx
  [index]
  (+ (* 2 index) 1))

(defn- right-child-idx
  [index]
  (+ (* 2 index) 2))

(defn- up-heap
  [heap]
  (loop [idx (- (count heap) 1)
         cur-heap heap]
    (let [parent-idx (parent-idx idx)]
      (cond
        (<= idx 0) cur-heap
        (< (cur-heap idx) (cur-heap parent-idx)) (recur
                                                   parent-idx
                                                   (swap cur-heap idx parent-idx))
        :else cur-heap
        ))))

(defn- min-child
  [heap idx]
  (let [left (left-child-idx idx)
        right (right-child-idx idx)]
    (cond
      (>= left (count heap)) -1
      (>= right (count heap)) left
      (< (heap left-child-idx) (heap right-child-idx)) left
      :else right)))

(defn- down-heap
  [heap]
  (loop [idx 0
         cur-heap heap]
    (let [left-idx (left-child-idx idx)
          right-idx (right-child-idx idx)
          current (cur-heap idx)
          min-child-idx (min-child cur-heap idx)]
      (cond
        (>= left-idx (count cur-heap)) cur-heap
        (> current (cur-heap min-child-idx)) (recur
                                               min-child-idx
                                               (swap cur-heap idx min-child-idx))
        :else (recur
                min-child-idx
                cur-heap)))))

(defn min-element
  [heap]
  (first heap))

(defn insert
  [heap element]
  (up-heap (conj heap element)))

(defn delete-min
  [heap]
  (down-heap (into [] (cons (last heap) (rest (pop heap))))))

(defn empty-heap
  "Creates an empty heap."
  []
  [])

(defn heapify
  [l]
  (reduce (fn [acc item]
            (insert acc item))
          (empty-heap)
          l))
