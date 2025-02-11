(ns main
  (:require-macros [macros :as m :refer [debug]])
  (:require [other-ns]
            [my-other-src :as src]
            ["fs" :as fs]
            ["path" :as path]
            ["url" :as url]))

(defn foo []
  (m/debug :foo (+ 1 2 3)))

(foo)
(debug :foo (+ 1 2 3 4))

(src/debug :dude (+ 1 2 3))

(-> (js* "import.meta.url")
    url/fileURLToPath
    path/dirname
    (path/resolve "foo.json")
    (fs/readFileSync "UTF-8")
    js/JSON.parse
    .-a
    println)
