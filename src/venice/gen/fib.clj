(ns venice.gen.fib
  (:gen-class))

(defn fib []
  "Generates a lazy sequence of Fibonacci numbers."
  ((fn helper [a b]
     (cons a (lazy-seq (helper b (+ a b)))))
    0 1))

