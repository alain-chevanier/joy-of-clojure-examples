(ns clojure-noob.async-comp
  (:require [clojure.core.async :as a :refer [<!! >!! <! >!]]))

(defn channels-example []


  (let [c (a/chan (a/dropping-buffer 10))]
    (>!! c "hello")
    (assert (= "hello" (<!! c)))
    (a/close! c))

  (let [c (a/chan)]
    (a/thread (>!! c "hello"))
    (assert (= "hello" (<!! c)))
    (a/close! c))

  (let [c (a/chan)]
    (a/go (>! c "hello"))
    (assert (= "hello" (<!! (a/go (<! c)))))
    (a/close! c))


  (let [c1 (a/chan)
        c2 (a/chan)]
    (a/thread (while true
                (let [[v ch] (a/alts!! [c1 c2])]
                  (println "Read" v "from" ch))))
    (>!! c1 "hi")
    (>!! c2 "there")))
