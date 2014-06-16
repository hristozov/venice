(ns venice.matrix.mul
  (:gen-class))

(defn- transpose [m]
  (apply pmap list m))

(defn mul
  "Multiplies two matrices."
  [m1 m2]
  (pmap (fn [row-1]
          (pmap (fn [col-2]
                  (reduce + (map * row-1 col-2)))
                (transpose m2)))
        m1))
