(ns functional-design.test.bowling-test
  (:require [clojure.test :as t]))

; スペアのときのフレームボーナスをつけて、フレーム化している
(defn to-frames [rolls]
  (loop [remaining-rolls rolls
         frames []]
    (cond
      (empty? remaining-rolls) frames

      (= 10 (first remaining-rolls))
      (recur (rest remaining-rolls) (conj frames (take 3 remaining-rolls)))

      (= 10 (reduce + (take 2 remaining-rolls)))
      (recur (drop 2 remaining-rolls) (conj frames (take 3 remaining-rolls)))

      :else
      (recur (drop 2 remaining-rolls) (conj frames (take 2 remaining-rolls))))))

; フレームごとにただた計算するだけ
(defn frame-score [score frame-and-bonus]
  (+ score (reduce + frame-and-bonus)))

(defn score [rolls]
  (reduce frame-score 0 (take 10 (to-frames rolls))))

(t/run-tests)

(t/deftest bowling-score
  (t/testing "オールガーター"
    (t/is (= 0 (score (take 20 (repeat 0))))))

  (t/testing "すべて1ピン"
    (t/is (= 20 (score (take 20 (repeat 1))))))

  (t/testing "1回スペア"
    (t/is (= 24 (score (concat [5 5 7] (take 17 (repeat 0)))))))

  (t/testing "1回ストライク"
    (t/is (= 20 (score (concat [10 2 3] (take 16 (repeat 0)))))))

  (t/testing "パーフェクトゲーム"
    (t/is (= 300 (score (take 12 (repeat 10)))))))