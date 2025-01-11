(ns functional-design.chapter6-spec
  (:require [speclj.core :refer [describe it should=]]
            [functional-design.chapter6 :refer [prime-factors-of]]))

(describe "prime factors"
  (it "1 has no prime factors"
    (should= [] (prime-factors-of 1)))) 