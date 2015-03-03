(ns venice.string.levenshtein
  (:gen-class))

(defn levenshtein 
  "Calculates Levenshtein distance"
  [s1 s2]
  (letfn [(indicator [i j] 
                     (if (= (.charAt s1 (- i 1))
                            (.charAt s2 (- j 1)))
                       0
                       1))
          (helper [i j]
                  (if (= 0 (min i j))
                    (max i j)
                    (min (+ (helper (- i 1) j) 
                            1)
                         (+ (helper i (- j 1)) 
                            1)
                         (+ (helper (- i 1) (- j 1))
                            (indicator i j)))))]
          (helper (.length s1) (.length s2))))
