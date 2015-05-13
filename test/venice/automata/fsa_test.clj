(ns venice.automata.fsa-test
  (:require [clojure.test :refer :all]
            [venice.automata.fsa :refer :all]))

(deftest is-automata
  (let [auto (create-fsa :A
                         #{:D}
                         {:A [1 :B]})]
  (is (automata? auto))))

(deftest accepting-three-ones
  (let [auto (create-fsa :A
                         #{:D}
                         {:A [1 :B]
                          :B [1 :C]
                          :C [1 :D]})]
    (is (true? (accepts? auto [1 1 1])))
    (is (false? (accepts? auto [1 1])))
    (is (false? (accepts? auto [1 1 1 1])))
    (is (false? (accepts? auto [])))))

(deftest accepting-repeated-strings
  (let [auto (create-fsa :B
                         #{:B}
                         {:A {\b :B}
                          :B {\a :A}})]
    (is (true? (accepts? auto "")))
    (is (true? (accepts? auto "ab")))
    (is (true? (accepts? auto "abab")))
    (is (true? (accepts? auto "ababab")))
    (is (false? (accepts? auto "a")))
    (is (false? (accepts? auto "aba")))
    (is (false? (accepts? auto "b")))
    (is (false? (accepts? auto "ababa")))))