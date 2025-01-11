(ns functional-design.spec.chapter6
  (:require [speclj.core :refer :all]))


(defn prime-factors-of [n]
  [])

(describe "素因数分解" 
 (it "1の素因数分解はなし"
   (should= [2] (prime-factors-of 1)))

 (it "test"
   (should= 1 1)))

(run-specs)
