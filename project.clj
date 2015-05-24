(defproject node-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2725"]]

  :node-dependencies [[source-map-support "0.2.8"]
                      [hapi "8.*"]]

  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-npm "0.4.0"]]

  :source-paths ["src" "target/classes"]

  :clean-targets ["out/server/node-cljs" "out/server/node-cljs.js"]

  :cljsbuild {
    :builds [{:id "server"
              :source-paths ["src/server"]
              :compiler {
                :main node-cljs.core
                :output-to "out/server/node-cljs.js"
                :output-dir "out/server"
                :optimizations :simple
                :target :nodejs
                :cache-analysis true
                :source-map "out/server/node-cljs.js.map"}}]})
