(ns venice.sort.qsort
  (:gen-class))

(defn smaller-than [l value]
  (filter #(< % value) l))

(defn greater-than-or-equal [l value]
  (filter #(>= % value) l))

(defn qsort [l]
  (if (empty? l)
    l
    (let [pivot-value (first l)
          list-without-pivot (rest l)
          smaller (smaller-than list-without-pivot pivot-value)
          greater (greater-than-or-equal list-without-pivot pivot-value)]
      (concat (qsort smaller)
              [pivot-value]
              (qsort greater)))))
