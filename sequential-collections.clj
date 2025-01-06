[1 2 3]

(get ["abc" false 99] -2)


(count [1 2 3 4 1])

(count [])

(vector 1 2 3)

(conj [1 2 3] 4 5 6)

(def v [1 2 3])

(conj v 4 5 6)

v

(def cards)

; vectorとlist。
; それぞれどっち使おうって感じか


(def cards '(10 :ace :jack 9))

; 先頭を取る
(first cards)

; 先頭以外のものを取る
(rest cards)

; 2つ目取る
(second cards)

; conjは定数時間になるように設計されている
; listの場合は先頭になる

(conj cards :queen)

(def stack '(:a :b))

(peek stack)

(doc peek)
(doc pop)

stack

(pop stack)

(peek v)

(pop v)



(def v [1 2 3])
(def l '(1 2 3))

; list

(peek l)
; 1
; 先頭のものを取り出して値を返す

(pop l)
; (2 3)
; 先頭を除外して値を返す

(peek v)
; 3
; 末尾のものを取り出して値を返す

(pop v)
; [1 2]
; 末尾のものを除外して値を返す