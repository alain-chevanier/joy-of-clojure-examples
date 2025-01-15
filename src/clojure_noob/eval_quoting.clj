(ns clojure-noob.eval-quoting)

;; Evaluation
;;

1

"Hello"

(cons 1 [1 2])

[(inc 3) (dec 8)]

;; Quoting
(def age 9)
(quote age)

;; the quoted list is not evaluated
(quote (cons 1 [1 2]))

(cons 1 (quote (2 3)))
(cons 1 '(2 3))

;; subtle difference
[1 (+ 2 3)]
'(1 (+ 2 3))

;; Syntax Quote using a single back-quote "`"
;; The operator "~" is used to unquote, that is evaluation of that s-expression is forced
`(1 ~(+ 0 2) 3)


;; The operator "~@" is called "unquote splicing" as it unpacks the sequence "x",
;; splicing it into the resulting list

(let [x '(1 2)] `(1 x))
;; => (1 clojure-noob.eval-quoting/x)

(let [x '(1 2)] `(1 ~x))
;; => (1 (1 2))

(let [x '(1 2)] `(1 ~@x))
;; => (1 1 2)

;; Auto-gensym (auto generated symbol)

`potion#
;; potion__11358__auto__
