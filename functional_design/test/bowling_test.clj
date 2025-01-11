(ns functional-design.test.bowling-test
  (:require [clojure.test :as t]))

(defn- to-frames [rolls]
  (partition 2 rolls))

(defn add-frame [score frame]
  (+ score (reduce + frame)))

(defn score [rolls]
	(reduce add-frame 0 (to-frames rolls))
  )

(t/run-tests)

(t/deftest bowling-score
  (t/testing "オールガーター"
    (t/is (= 0 (score (take 20 (repeat 0)))))) 

  (t/testing "すべて1ピン"
    (t/is (= 20 (score (take 20 (repeat 1))))))

  (t/testing "1回スペア"
    (t/is (= 24 (score (concat [5 5 7] (take 17 (repeat 0)))))))
 	)