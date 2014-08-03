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
    (is (false? (accepts? auto [1 1])))))