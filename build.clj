(require '[clojure.java.io :as io]
         '[cljs.build.api :as b])

(b/build (b/inputs "src")
         {:main       'sundbry.autobahn
          :target :nodejs
          :output-to  "resources/autobahn_cljs.js"
          :output-dir "build"
          :verbose    true
          :externs    ["process.js"]
          :language-in :ecmascript6
          :language-out :ecmascript5
          :foreign-libs (let [entry {:file (.getAbsolutePath (io/file "src/libs/npm_deps.js"))
                                     :provides ["libs.npm-deps"]
                                     :language-in :ecmascript6
                                     :language-out :ecmascript5
                                     :module-type :commonjs}]
                          (into [entry] (b/node-inputs [entry])))
          :optimizations :advanced
          :pretty-print true
          :closure-warnings {:non-standard-jsdoc :off
                             :global-this :off}})

(System/exit 0)