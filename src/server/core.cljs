(ns node-cljs.core
  (:require [cljs.nodejs :as node]))

(node/enable-util-print!)

(def hapi (node/require "hapi"))

(defn say-hello! [request reply]
  (reply "Hello, world!"))

(defn -main []
  (let [Server (.-Server hapi)
        server (Server.)
        ]
    (.connection server (js-obj "port" 3000))
    (.route server (js-obj "method" "GET" "path" "/" "handler" say-hello!))
    (.start server (fn []
                     (println "Server started on port 3000")))))

(set! *main-cli-fn* -main)
