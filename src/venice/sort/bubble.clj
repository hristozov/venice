(ns venice.sort.bubble
  (:gen-class))

(defn swap-front [[a b & rest]] (concat [b] [a] rest))

