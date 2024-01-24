(ns clojure-noob.functions
  (:require clojure.set))

;; ways to define a function
(def square-1
  (fn [x]
    (println "calculating the square of x: " x)
    (* x x)))

(square-1 9)

(defn square
  "Doc String for square func, use it to document what the function does"
  [x]
  (println "Calculating the square of x: " x)
  (* x x))

(square 12)

;; Multi-arity Functions
;; Several ways to define functions with a variable number of arguments
(def my-str "Hello World!")
(println my-str)

(defn make-set
  ([x] #{x})
  ([x y] #{x y})
  ([x y & zs] (clojure.set/union #{x y} (apply make-set zs))))

(def my-set (make-set 1 2 3 4))
(println my-set)

(def make-set-1
  (fn [x y]
    #{x y}))

(def my-set-1 (make-set-1 1 2))
(println my-set-1)


;; Using anonymous functions

(def make-list-0 #(list))
(make-list-0)

(def make-list-1 #(list %1 %2))
(make-list-1 6 7)

(def make-list-2 #(list %1 %2 %&))
(make-list-2 6 7 8 9)

;; LOOPS - RECUR

(defn print-down-from
  "print all numbers from x to 1 in decreasing order"
  [x]
  (when (pos? x)
    (println x)
    (recur (dec x))))

(print-down-from 6)

(defn sum-down-from
  "Sum all numbers from x to 1 in decreasing order"
   [sum x]
  (if (pos? x)
    (recur (+ sum x) (dec x))
    sum))

(sum-down-from 0 10)

(defn sum-down-from-1 [initial-x]
  (loop [sum 0, x initial-x]
    (if (pos? x)
      (recur (+ sum x) (dec x))
      sum)))

(sum-down-from-1 10)

;; Note: RECUR must be in a tail position, that is, last instructiohn of an execution branch\
