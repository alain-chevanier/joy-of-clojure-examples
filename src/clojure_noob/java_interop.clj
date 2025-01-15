(ns clojure-noob.java-interop
  (:import java.util.Locale)
  )

;; Interop static class member from Java
(println Locale/JAPAN)

;; java.lang is imported by default as in any java code
(Math/sqrt 9)

;; Note: ClojureScript does not support this feature as JS does not either

;; Creating a instance of a class
(let [point (new java.awt.Point 0 1)]
  (println "My point: " point))
;; Note new arguments are passed to the constructor as expected
;;


;; Clojures core Collection types can be used as arguments to Java constructors
(let [my-map (new java.util.HashMap {"foo" 42 "bar" 9})
      succint-map (java.util.HashMap. {"hello" "world"})]
  (println "my map: " my-map)
  (println "succint map definition" succint-map))

;; Similar for ClojureScript but for core or globally accesible types we use the prefix js
;; for example (js/Date.)
