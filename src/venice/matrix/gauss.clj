(ns venice.matrix.gauss
  (:gen-class))

(defn- swap [v i1 i2] 
  (assoc v i2 (v i1) i1 (v i2)))

(defn- column-pivot-index
  [m i]
  (println "ccc" m i)
  (let [column (map #(nth % i) m)]
    (first (apply max-key
                  #(Math/abs (second %))
                  (map-indexed vector column)))))

(defn gauss
  [m]
  (let [number-of-rows (count m)
        number-of-columns (count (first m))]
    (loop [column-index 0
           matrix m]
      (let [pivot-idx (column-pivot-index matrix column-index)]
        (println column-index pivot)))))
