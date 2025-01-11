(ns functional-design.spec.chapter6
  (:require [speclj.core :refer [should=]]))

(should= 1 2)

(should= 1 1)

(defn prime-factors-of [n]
  [])
(should= [1] (prime-factors-of 1))

