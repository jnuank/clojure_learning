(ns functional-design.test.bowling-test
  (:require [clojure.test :as t]))


(defn score [rolls]
  (reduce + rolls))

(t/run-tests)

(t/deftest bowling-score
  (t/testing "オールガーター"
    (t/is (= 0 (score (take 20 (repeat 0)))))) 

  (t/testing "すべて1ピン"
    (t/is (= 20 (score (take 20 (repeat 1))))))

  (t/testing "1回スペア"
    (t/is (= 24 (score [5 5 7]))))
 	)