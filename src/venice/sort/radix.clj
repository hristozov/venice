(ns venice.sort.radix
  (:gen-class))

(defn- log-base
  [base number]
  (if (= 0 number)
    0
    (/ (Math/log10 number) (Math/log10 base))))

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

(defn- do-radix
  ([l base]
   (if (empty? l)
     l
     (let [biggest-element (apply max l)
           logarithm-of-biggest (log-base base biggest-element)
           biggest-element-digits (+ (int logarithm-of-biggest) 1)]
       (loop [current-position 1
              current-list l]
         (if (> current-position biggest-element-digits)
           current-list
           (recur
             (+ current-position 1)
             (sort-by-position current-list current-position base))))))))

(defn radix
  "Performs fairly slow (with non-optimal constants) LSD radix sort with a given
  base on a list. Default base is 10."
  ([l] (radix l 10))
  ([l base]
   (let [grouped (group-by pos? l)
         positive-items (grouped true)
         negative-items (grouped false)
         negative-items-inv (map - negative-items)
         positive-sorted (do-radix positive-items base)
         negative-inv-sorted (do-radix negative-items-inv base)
         negative-sorted (map - negative-inv-sorted)
         result (into
                  (into (empty l) (reverse negative-sorted))
                  positive-sorted)]
     ; XXX: This is retarded.
     (if (list? l)
       (reverse result)
       result))))
