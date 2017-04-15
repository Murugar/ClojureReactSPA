(defproject ClojureReact "0.1.0"
  :description "Clojure React SPA"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-time "0.11.0"] ; required due to bug in `lein-ring uberwar`
                 [metosin/compojure-api "1.1.1"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [ch.qos.logback/logback-core "1.1.3"]
                 [ch.qos.logback/logback-classic "1.1.3"]
                 [net.logstash.logback/logstash-logback-encoder "4.5.1"]]
  :ring {:handler ClojureReact.routes.handler/app :port 3399 :reload-paths ["src/"]}
  :uberjar-name "ClojureReact.jar"
  :source-paths ["src/"]
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[lein-ring "0.9.7"]]}}
  :main ClojureReact.core)
