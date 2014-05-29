(ns venice.sort.bubble
  (:gen-class))

(defn swap-front [[a b & rest]]
  (concat [b] [a] rest))

(defn process-list [l]
  (if (< (count l) 2)
    l
    ((fn [[f s & tail]]
       (let [smaller (min f s)
             bigger (max f s)]
         (concat [smaller]
                 (process-list
                   (concat [bigger]
                           tail)))))
     l
     )))

(defn bubble [l]
  (if (empty? l)
    l
    (let [processed-list (process-list l)
          len (count processed-list)
          l-without-last (drop-last processed-list)
          last-element (last processed-list)]
      (concat (bubble l-without-last)
              [last-element])
      )))

