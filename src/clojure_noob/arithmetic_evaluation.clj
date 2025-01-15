(ns clojure-noob.arithmetic-evaluation
  (:require [clojure.string :as str]))

(declare evaluate-rpn-aux)

(defn evaluate-rpn
  [tokens]
  (evaluate-rpn-aux tokens '()))

(defn evaluate-rpn-aux
  [tokens operands]
  (cond
    (empty? tokens)
    (first operands)
    :else
    (let [[head & tail] tokens
          [left-operand right-operand & remaning-operands] operands
          ops (if (number? head)
                (conj operands head)
                (->> [right-operand left-operand]
                     (apply head)
                     (conj remaning-operands)))]
      (evaluate-rpn-aux tail ops))))

(defn filter-and-sum
  [values]
  (cond
    (empty? values)
    0
    :else
    (let [[head & tail] values
          value (if (even? head) head 0)]
      (+ value (filter-and-sum tail)))))

(defn word-count
  [words]
  (-> words
      str/lower-case
      (str/split #" +")
      frequencies))

(defn find-max
  [coll]
  (cond
    (empty? coll)
    nil

    (= 1 (count coll))
    (first coll)

    :else
    (let [[head & tail] coll
          max-tail (find-max tail)]
      (if (> head max-tail)
        head
        max-tail))))

(defn compress-seq
  [coll]
  (cond
    (empty? coll)
    coll

    (= 1 (count coll))
    coll

    :else
    (let [[head & tail] coll
          [tail-head] tail
          prefix (if (= head tail-head) [] [head])]
      (into [] (concat prefix (compress-seq tail))))))
