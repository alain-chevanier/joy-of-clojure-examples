(ns clojure-noob.functions
  (:require clojure.set))

;; multi-arity functions

(def make-set-1
  (fn [x y]
    #{x y}))

(defn make-set
  ([x] #{x})
  ([x y] #{x y})
  ([x y & zs] (clojure.set/union #{x y} (apply make-set zs))))

(def my-set-1 (make-set-1 1 2))

(def my-set (make-set 1 2 3 4))

(def my-str "Hello World!")

(println my-str)
(println my-set)
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

(defn sum-down-from [sum x]
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
