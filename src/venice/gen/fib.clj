(ns venice.gen.fib
  (:gen-class))

(defn fib []
  ((fn helper [a b]
     (cons a (lazy-seq (helper b (+ a b)))))
   0 1))

