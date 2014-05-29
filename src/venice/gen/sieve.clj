(ns venice.gen.sieve
  (:gen-class))

(defn sieve []
  ((fn helper [members-seq]
    (let [current (first members-seq)
          tail (rest members-seq)]
      (cons current
            (lazy-seq (helper (filter
                                #(not (= (mod % current) 0))
                                tail)))))) (iterate inc 2)))

