(ns venice.sort.bubble
  (:gen-class))

(defn swap-front [[a b & rest]]
  (concat [b] [a] rest))

(defn process-list [l]
  (if (< (count l) 2)
    l
    ((fn [f s & rest]
       (let [smaller (min f s)]
         [bigger (max f s)]
         (concat [smaller] [bigger] rest))))))

(defn drop-last [l]
  (if (empty? l)
    l
    (take (- (count l) 1) l)))

(defn bubble [l]
  (if (empty? l)
    l
    (let [l-without-last (take (- (count l) 2) l)]
      [last-element (nth (- (count l) 1) l)])
    wtf))

