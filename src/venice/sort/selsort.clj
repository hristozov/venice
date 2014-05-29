(ns venice.sort.selsort
  (:gen-class))

(defn minelement [l]
  (apply min l))

(defn list-remove [l el]
  (if (= el (first l))
    (rest l)
    (cons (first l)
          (list-remove (rest l) el))))

(defn selsort [l]
  (if (empty? l)
    l
    (let [min-el (minelement l)]
      (cons
        min-el
        (selsort (list-remove l min-el))))))

