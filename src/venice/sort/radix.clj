(ns venice.sort.radix
  (:gen-class))

(defn- get-digit-at-position [number position]
  (int (Math/floor
         (/
           (mod number (Math/pow 10 position))
           (Math/pow 10 (- position 1))))))

(defn- sort-by-position [l position]
  (flatten
    (map (fn [digit]
           (filter
             #(= (get-digit-at-position % position) digit)
             l))
      (range 0 10))))

(defn radix
  "Performs base 10 radix sort on a list. Does not support negative numbers."
  [l]
  (if (empty? l)
    l
    (let [biggest-element (apply max l)
          biggest-element-digits (+ (Math/floor (Math/log10 biggest-element)) 1)]
      (loop [current-position 1,
             current-list l]
        (if (> current-position biggest-element-digits)
          current-list
          (recur
            (+ current-position 1)
            (sort-by-position current-list current-position)))))))
