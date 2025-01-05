(defn fibs-work [n i fs]
  (if (= n i)
    fs
  ; 最後に自分自身(fibs-work)を呼び出しているので末尾呼び出しになっている
     (recur n (inc i) (conj fs (apply + (take-last 2 fs))))))

(defn fibs [n]
  (cond
    (< n 1) []
     (= n 1) [1]
     :else (fibs-work n 2 [1 1])))

(fibs 20)


(fibs-work 6 6 [1 1])

(conj [1 1] [2])

(concat [1 2] [2])

(doc take-last)

(take-last 2 [1 2 3 4 5])

(defn fib [n]
  (cond
    (< n 1) nil
     (<= n 2) 1
     :else (+ (fib (dec n)) (fib (- n 2)))))

(defn fibs [n]
  (map fib (range 1 (inc n))))

(fibs 4)

; timeを入れると時間が測れる
(time (fib  20))

(map fib (range 1 21))

(fib 20)

(defn ifib
  ([n a b]
   (if (= 0 n)
     b
     (ifib (dec n) b (+ a b)))) 
  ([n]
   (cond 
     (< n 1) nil
   	 (<= n 2) 1
   	 :else (ifib (- n 2) 1 1))))

(time (fib 20))

(time (ifib 20))


; 
