(ns clojure-noob.polymorphism
  (:import [java.util List]))

;; Protocols work like interfaces or mix-ins
(defprotocol Concatenable
  (my-concat [this other]))

(extend-type String
  Concatenable
  (my-concat [this other]
    (.concat this other)))

(extend-type List
  Concatenable
  (my-concat [this other]
    (concat this other)))

;; Now concat works with both types
(my-concat "Hello " "World")
(my-concat [1 2 3] [4 5 6])

;; We could overwrite only string.cat without reimplementing
;; all methods from String, avoding the known "expression problem"
;; which happens in java.

(def my-vector [5 3 6])
(my-vector 1)


(letfn [(square [x] (* x x))
         (double [y] (* 2 y))]
  (println (square 5))  ; Prints 25
  (println (double 3))) ; Prints 6

(map int [\a \0])

(defn map-pos-to-nums
  [position]
  (->> position
       (map int)))

(map-pos-to-nums "b3")
