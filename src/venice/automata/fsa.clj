(ns venice.automata.fsa
  (:gen-class))

(def ^:private ^:const ERROR_STATE
  "Error state in the automata."
  :error)

(defn- default-transition
  "Default transition map for the cases where undefined input characters are
  encountered. Will always lead to the error state."
  [ignored]
  ERROR_STATE)

(defn- do-transitions [start transitions input]
  (reduce (fn [state input]
            ((transitions state default-transition) input))
          start
          input))

(defprotocol Automata 
  (accepts? [this input] "Checks whether an automata accepts a given input."))

(defrecord AutomataImpl [start end transitions]
  Automata (accepts? [this input]
                     (let [final-states (:end this)
                           state-input (do-transitions (:start this)
                                                       transitions
                                                       input)]
                       (and (not= state-input ERROR_STATE)
                            (contains? final-states state-input)))))

(defn create-fsa
  "Automata constructor."
  [start end transitions]
  {:pre [(set? end)
         (keyword? start)
         (map? transitions)]}
  (->AutomataImpl start end transitions))

(defn automata?
  "Checks whether a given value is an automata."
  [value]
  (satisfies? Automata value))
