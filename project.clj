(defproject clj "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-beta1"]
                 [wrepl "0.1.0-SNAPSHOT"]
                 [wrepl.puget "0.1.0-SNAPSHOT"]
                 [wrepl.pomegranate "0.1.0-SNAPSHOT"]]
  :main ^:skip-aot wrepl.main
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
