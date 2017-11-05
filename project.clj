(defproject net.ofnir/clj "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-beta4"]
                 [net.ofnir/wrepl "0.1.0-SNAPSHOT"]
                 [net.ofnir/wrepl.puget "0.1.0-SNAPSHOT"]
                 [net.ofnir/wrepl.pomegranate "0.1.0-SNAPSHOT"]]
  :main ^:skip-aot wrepl.main
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})