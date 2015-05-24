(ns node-cljs.core
  (:require [cljs.nodejs :as node]))

(node/enable-util-print!)

(def hapi (node/require "hapi"))

(defn say-hello! [request reply]
  (reply "Hello, world!"))

(defn setup-hapi! [port routes]
  (let [Server (.-Server hapi)
        server (Server.)]
    (.connection server (js-obj "port" port))
    (.route server routes)
    (.start server (fn []
                     (println "Server started on port 3000")))))

(defn -main []
  (setup-hapi! 3000 (array (js-obj "method" "GET" "path" "/" "handler" say-hello!))))

(set! *main-cli-fn* -main)
