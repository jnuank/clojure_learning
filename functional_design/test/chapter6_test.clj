(ns functional-design.test.chapter6-test
  (:require [clojure.test :as t]))


(defn prime-factors-of [n]
  (if (> n 1) [n] []))

(t/run-tests)

(t/deftest prime-factors
  (t/testing "1の素因数分解はなし"
    (t/is (= [] (prime-factors-of 1))))
  
  (t/testing "2の因数分解"
    (t/is (= [2] (prime-factors-of 2))))
  
  (t/testing "3の因数分解"
    (t/is (= [3] (prime-factors-of 3))))
  
  (t/testing "4の因数分解"
    (t/is (= [2 2] (prime-factors-of 4)))))
