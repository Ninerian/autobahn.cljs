(defproject sundbry/autobahn.cljs "0.2.0-SNAPSHOT"
  :description "Clojurescript bindings for autobahn.js"
  :plugins [[lein-cljsbuild "1.1.5"]]
  :dependencies [[cljsjs/autobahnjs "0.12.0-0"]]
  :source-paths ["src"]
  :clean-targets ^{:protect false} ["resources/"
                                    "build"
                                    :target-path]
  :cljsbuild {:builds
              [{:source-paths  ["src"]
                :id            :client
                :compiler
                               {:output-to  "resources/autobahn_cljs.js"
                                :output-dir "build"
                                :externs    ["process.js"]
                                :language-in :ecmascript6
                                :language-out :ecmascript5
                                :npm-deps   {:autobahn "0.12.0"}
                                :closure-warnings {:non-standard-jsdoc :off
                                                   :global-this :off}
                                :optimizations :advanced}}]}
                 ;:preamble ["autobahn.min.js"]

  :profiles
  {:dev
   {:dependencies [[org.clojure/clojure "1.8.0"]
                   [org.clojure/clojurescript "1.9.515"]
                   [org.clojure/core.async "0.2.374"]]}})
