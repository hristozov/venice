(ns venice.automata.fsa
  (:gen-class))

(defprotocol Automata 
  (accepts? [this input] "Checks whether an automata accepts a given input."))

(defrecord AutomataImpl [start end transitions]
  Automata (accepts? [this input]
                     (contains? (:end this)
                                (reduce (fn [state input]
                                          (((:transitions this) 
                                            state) 
                                           input))
                                        (:start this)
                                        input))))

(defn create-fsa
  "Automata constructor"
  [start end transitions]
  {:pre [(set? end)
         (keyword? start)
         (map? transitions)]}
  (->AutomataImpl start end transitions))

(defn automata?
  "Checks whether a given value is an automata."
  [value]
  (= AutomataImpl (type value)))
