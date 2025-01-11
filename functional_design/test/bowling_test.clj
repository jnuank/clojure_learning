(ns functional-design.test.bowling-test
  (:require [clojure.test :as t]))


(defn score [rolls] 0)

(t/run-tests)

(t/deftest bowling-score
  (t/testing "オールガーター"
    (t/is (= 0 (score (take 20 (repeat 0)))))))