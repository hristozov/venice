(ns venice.sort.selsort
  (:gen-class))

(defn selsort
  "Performs a selection sort on a list."
  [l]
  (loop [unsorted-part l
         sorted-part []]
    (if (empty? unsorted-part)
      sorted-part
      (let [min-element (apply min unsorted-part)
            min-element-arity (count
                                (filter #{min-element} unsorted-part))
            new-unsorted-part (filter
                                #(not (= % min-element))
                                unsorted-part)]
        (recur
          new-unsorted-part
          (concat sorted-part (repeat min-element-arity min-element)))))))
