(ns venice.sort.radix
  (:gen-class))

(defn- log-base
  [base number]
  (/ (Math/log10 number) (Math/log10 base)))

(defn- get-digit-at-position
  "Gets the digit on a specified position in a number. Base 10."
  [number position base]
  ; TODO: Use bit shift for base 2
  (let [pow-base-position (Math/pow base position)]
    (int
      (/
        (mod number pow-base-position)
        (/ pow-base-position base)))))

(defn- sort-by-position
  "Sorts a list by the digits on a specified position."
  [l position base]
  (flatten
    (map (fn [digit]
           (filter
             #(= (get-digit-at-position % position base) digit)
             l))
         (range 0 base))))

(defn radix
  "Performs fairly slow (with non-optimal constants) LSD radix sort with a given
  base on a list. Does not support negative numbers. Default base is 10."
  ([l] (radix l 10))
  ([l base]
   (if (empty? l)
     l
     (let [biggest-element (apply max l)
           biggest-element-digits (+ (int (log-base base biggest-element)) 1)]
       (loop [current-position 1
              current-list l]
         (if (> current-position biggest-element-digits)
           current-list
           (recur
             (+ current-position 1)
             (sort-by-position current-list current-position base))))))))
