(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot"))

(println "Cleanliness is next to godliness")


(def region-data
  {:region/postcode "12345"})

(:region/postcode region-data)

;; C-c l g

(defn make-train-sound
  ""
  []
  (println "Choo Choo!"))

(make-train-sound)
