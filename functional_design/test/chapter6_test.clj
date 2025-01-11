(ns functional-design.test.chapter6-test
  (:require [clojure.test :as t]))


(defn prime-factors-of [n]
  (loop [n n
         divisor 2
         factors []]
  (if (> n 1)
    (if (zero? (rem n divisor))
      (recur (/ n divisor) divisor (conj factors divisor))
      (recur n (inc divisor) factors))
    factors)))


(t/run-tests)

(t/deftest prime-factors
  (t/testing "1の素因数分解はなし"
    (t/is (= [] (prime-factors-of 1))))

  (t/testing "2の因数分解"
    (t/is (= [2] (prime-factors-of 2))))

  (t/testing "3の因数分解"
    (t/is (= [3] (prime-factors-of 3))))

  (t/testing "4の因数分解"
    (t/is (= [2 2] (prime-factors-of 4))))

  (t/testing "5の因数分解"
    (t/is (= [5] (prime-factors-of 5))))

  (t/testing "6の因数分解"
    (t/is (= [2 3] (prime-factors-of 6))))

  (t/testing "8の因数分解"
    (t/is (= [2 2 2] (prime-factors-of 8))))

  (t/testing "9の因数分解"
    (t/is (= [3 3] (prime-factors-of 9))))
  )


; 確認用

(->> [2]
 (cons 4)
 (cons 3))

(defn recur-check [n]
  (if (zero? n)
    []
    (do (println n) (cons n (recur-check (dec n))))))

(defn iteration-check [n]
  (loop [n n
         acc []]
    (if (> n 0)
      (do (println n)(recur (dec n) (cons n acc)))
      acc)))


(iteration-check 3)
; これと一緒
(cons 1 [2 3])
; [2 3]はこれと一緒
(cons 2 [3])
; [3]はこれと一緒
(cons 3 [])

; recurでTOCが実行されると、goto文ぽくなるので、毎loopごとに関数が実行されて値が評価される
; 3から1までlistの先頭にくっつける処理をしているので、[1 2 3]

(recur-check 3)
; これと一緒
(cons 3 (cons 2 (cons 1 [])))

; 再帰で呼び出すと、スタックしていき、最後に呼び出された関数から順番に呼び出される
; (cons 3 (cons 2 (cons 1 [])))という形になり、1から3までlistの先頭にくっつける処理