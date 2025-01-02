(+ 2 3)

(defn fanctorial [n]
  (if (= n 0)
    1
   	(* n (fanctorial (dec n)))))


42N

-1.5

22/7

"hello"

\e

#"[0-9]+"

\newline

\space

" "

"\n"

\tab

map
+
clojure.core/+


true false
:alpha

:release/alpha

'(1 2 3) ;list
[1 2 3 ] ;vector
#{1 2 3} ;set
{:a 1 :b 2} ;map

; ↑これらのリテラルコレクションの違いはなんだろう


(def x 7)

x

(+ 7654 1234)

(/ (+ (+ (* 3 4) 7) 5) 10)

(/ (+ 7 (* 3 4) 5) 10)

; ↑のパターンをスレッドマクロにしてみたパターン
; あまり綺麗になった感じはしない
; (/ (+ (*3 4) 7 5) 10)
; ↑こういう感じになっている
(-> (* 3 4)
    -> (+ 7 5)
    (/ 10))

(doc mod)
(doc rem)

(find-doc "trace")