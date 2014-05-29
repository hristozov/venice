(ns venice.sort.selsort
  (:gen-class))

(defn selsort [l]
  (loop [current-list l
         result []]
    (if (empty? current-list)
      result
      (let [min-el (apply min current-list)
            min-el-arity (count (filter #{min-el} current-list))
            l-without-min (filter #(not (= % min-el)) current-list)]
        (recur l-without-min (concat result (repeat min-el-arity min-el)))))))

