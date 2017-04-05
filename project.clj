(defproject sundbry/autobahn.cljs "0.1.2-SNAPSHOT"
  :description "Clojurescript bindings for autobahn.js"
  :plugins [[lein-cljsbuild "1.0.6"]]
  :repositories [["snapshots" {:url "http://mises.etheride.com:8081/nexus/content/repositories/snapshots"}]]
  :dependencies [[cljsjs/autobahnjs "0.9.9-0"]]
  :source-paths ["src"]
  :cljsbuild {:builds
              [{:source-paths ["src"]
                :id :client
                :compiler
                {:output-to "resources/autobahn_cljs.js"
                 :output-dir "build"
                 :optimizations :advanced}}]}
                 ;:preamble ["autobahn.min.js"]

  :profiles
  {:dev
   {:dependencies [[org.clojure/clojure "1.6.0"]
                   [org.clojure/clojurescript "1.7.170"]
                   [org.clojure/core.async "0.2.374"]]}})
