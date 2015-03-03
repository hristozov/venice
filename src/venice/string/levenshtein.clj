(ns venice.string.levenshtein
  (:gen-class))

(defn- indicator [s1 s2 i j] 
  (if (= (.charAt s1 (- i 1))
         (.charAt s2 (- j 1)))
    0
    1))

(defn- helper [s1 s2 i j]
  (if (= 0 (min i j))
    (max i j)
    (min (+ (helper s1 s2 (- i 1) j) 
            1)
         (+ (helper s1 s2 i (- j 1)) 
            1)
         (+ (helper s1 s2 (- i 1) (- j 1))
            (indicator s1 s2 i j)))))

(defn levenshtein 
  "Calculates Levenshtein distance"
  [s1 s2]
  (helper s1 s2 (.length s1) (.length s2)))
