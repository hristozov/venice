(ns venice.matrix.mul
  (:gen-class))

(defn- mul-column [c1 c2]
  (pmap #(* %1 %2) c1 c2))

(defn- transpose [m]
  (apply pmap list m))

(defn mul [m1 m2]
  (pmap (fn [row-1]
          (pmap (fn [col-2]
                  (reduce + (pmap * row-1 col-2)))
                (transpose m2)))
        m1))
