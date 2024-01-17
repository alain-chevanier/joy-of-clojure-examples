(ns clojure-noob.core-test
  (:require [clojure.test :refer :all]
            [clojure-noob.core :refer :all]))

(deftest a-test
  (testing "test a, this pass"
    (is (= 1 1))))

(deftest b-test
  (testing "test b, this pass too"
    (is (= 3 3))))

;; but I
