(ns venice.matrix.add
  (:gen-class))

(defn add
  "Adds two matrices."
  [m1 m2]
  (map (fn [row1 row2]
         (map + row1 row2)) m1 m2))
