(ns venice.sort.radix
  (:gen-class))

(defn- get-digit-at-position [number position]
  "Gets the digit on a specified position in a number. Base 10."
  (let [pow-10-position (Math/pow 10 position)]
    (int
      (/
        (mod number pow-10-position)
        (/ pow-10-position 10)))))

(defn- sort-by-position [l position]
  "Sorts a list by the digits on a specified position."
  (flatten
    (map (fn [digit]
           (filter
             #(= (get-digit-at-position % position) digit)
             l))
         (range 0 10))))

(defn radix
  "Performs fairly slow (with non-optimal constants) base-10 LSD radix sort on a
  list. Does not support negative numbers."
  [l]
  (if (empty? l)
    l
    (let [biggest-element (apply max l)
          biggest-element-digits (+ (int (Math/log10 biggest-element)) 1)]
      (loop [current-position 1,
             current-list l]
        (if (> current-position biggest-element-digits)
          current-list
          (recur
            (+ current-position 1)
            (sort-by-position current-list current-position)))))))
