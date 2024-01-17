(ns clojure-noob.collections)

;; A form is any clojure object meant to be evaluated
;; lists, vector, maps, numbers, keywords, symbols
;; Special forms are those that are not typically implemented
;; using the base clojure form, eg. "dot" operator (.) used for
;; java interoperability
;;
;; List example
;; (yankee hotel foxtrot)
;;
;; if yankee is a function the remaining items in the list are
;; evaluated in order and the results are passed to yankee as its parameters
;;
;; if yankee is a macro or special operator the remaining iterms in the list
;; are not necessarly evaluated but are processed as defined by the macro or operator
