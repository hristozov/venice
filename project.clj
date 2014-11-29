(defproject venice "0.1.0-SNAPSHOT"
  :description "experiments"
  :url "http://github.com/hristozov/venice"
  :license {:name "BSD 3-Clause License"
            :url "http://opensource.org/licenses/BSD-3-Clause"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot venice.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[com.jakemccrary/lein-test-refresh "0.5.0"]
                             [jonase/eastwood "0.2.0"]
                             [lein-cloverage "1.0.2"]]}})
