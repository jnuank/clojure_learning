(ns functional-design.test.chapter6-test
  (:require [clojure.test :as t]))


(defn prime-factors-of [n]
  [])

(t/deftest prime-factors
  (t/testing "1の素因数分解はなし"
    (t/is (= [1] (prime-factors-of 1)))))

(t/run-tests)