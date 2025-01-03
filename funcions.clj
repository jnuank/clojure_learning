(defn greet [name] (str "Hello, " name))


; 関数定義
(defn messenger
  ([] (messenger "hello world"))
  ([& msgs] (apply println msgs)))

(messenger "clojure !" " args")

(defn hello [greeting & foo]
  (println greeting foo))

(hello "greeting" "aa" "bb")

; 匿名関数
(fn [message] (println message))

; 省略形
; (fn [x] (+ 6 x))
(#(+ 6 %) 5)

; (fn [x y ] (+ x y))
(#(+ %1 %2) 1 2)

; (fn [x y & zx] (println x y zx))
(#(println %1 %2 %&) "a" "b" "c" "d")


; Wrong number of args (2) でエラー
; (fn [x] ([x])) という形になるので、引数
(#([%]) 1 2)

; vectorつくるならこれ
(#(vector %) "aaa")

;; ((fn [& xs] (println (list* xs))) "a " "b ")

(defn double-+
  [a b]
  (* 2 (+ a b)))

(defn double-*
  [a b]
  (* 2 (* a b)))

(defn double-op
  [f a b]
  (* 2 (f a b)))

(double-+ 2 3)
(double-* 2 3)

; high order functionの例
(double-op - 2 3)

; apply

(apply println '("a" "b" "c"))
(apply println "a" '("b" "c"))
(apply + "a" "1" "2" "3" "4" "5" '("b" "c"))


(defn plot [shape coords]
  (plotxy shape (first coords) (second coords)))

(list* 1 [3 2])

()

; letの使い方
(let [x 1 y 2] (+ x y))

; letの外側だとエラーとなる
((let [x 1 y 2]) (+ x y))

; クロージャを作成
; fnはspecial form→closureを作成する
(defn messenger-builder [greeting]
  (fn [who] (println greeting who)))

; greetingに、Helloを渡した匿名関数を定義
(def hello-er (messenger-builder "Hello"))

; 外側から渡せる
(hello-er "world")


((fn  [message]  (println message) ) "mess")
(#(println %) "mess")


; テスト

; 1
(defn greeting [] (println "Hello"))

(greeting)

; 2
(def greet (fn [] (println "Hello")))

(def greet #(println "Hello!"))
(greet)

; 3

(defn greeting
  ([] (str "Hello World!"))
  ([x] (str "Hello" \space x "!"))
  ([x y] (str x "," \space y "!")))

(assert (= "Hello World!" (greeting)))
(assert (= "Hello Clojure!" (greeting "Clojure")))
(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))

; 4

(defn do-nothing [x]
  (identity x))

(do-nothing 1)

(defn always-thing [_] 100)

(always-thing "a")


