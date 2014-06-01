(ns venice.search.bin
  (:gen-class))

(defn bin [haystack needle]
  "Binary search for an element in a sorted list."
  (loop [start 0
         end (count haystack)]
    (let [mid-idx (+ (bit-shift-right (- end start) 1) start)
          mid-element (if (and (< mid-idx (count haystack)) (>= mid-idx 0))
                        (nth haystack mid-idx)
                        nil)]
      (cond
        (= needle mid-element) true
        (or (nil? mid-element) (= start end)) false
        (< mid-element needle) (recur (+ mid-idx 1) end)
        (> mid-element needle) (recur start (- mid-idx 1))))))

