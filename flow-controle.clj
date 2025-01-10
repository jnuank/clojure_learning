
(str "2 is " (if (even? 5) "even" "odd"))

(if (true? false) "impossibled!")

(if true :truthy :falsey)

(if (Object.) :truthy :falsey)

(if [] :truthy :falsey)

(if 0 :truthy :falsey)

(if false :truthy :falsey)

(if nil :truthy :falsey)

; if and do 

(if (even? 5)
  (do (println "even")
      true)
  (do (println "odd")
      false))

; when

;; (import 'java.lang.RuntimeException)


(let [x -1] (when (neg? x)
  (throw (java.lang.RuntimeException. (str "x must be positive: " x)))))


; case 

(defn foo [x]
  (case x 
    5 "x is 5"
   	10 "x is 10"
   	"x is not 5 or 10"))


(foo 10)

(foo 5)

(foo 1)

(defn bar [x]
(case x
  :five "five"
  :ten "ten"
)  )

(bar :five)
(bar :ten)
(bar :fuga)

(dotimes [i 3]
  (println "i is" i))


; lazy seqだった場合は強制的に評価する
(doseq [i (range 3)]
  (println "i is" i))


(doseq [letter [:a :b]
        number (range 3)]
		(println [letter number]))

(doc prn)

(doc println)


(do (println "hello") (println "world") true)

(do 1 2 3 )
; 3

; loop

(loop [i 0]
  (if (< i 10)
    (recur (inc i))
    i))


(defn increase [i]
  (if (< i 10)
    (recur (inc i))
    i))

(increase 0)

; exceptions


(try
  (/ 2 1)
  (catch ArithmeticException e
    "divide by zero")
    (finally
      (println "clean up")))

; throw
(try
  (throw (Exception. "something went wrong"))
  (catch Exception e (.getMessage e)))

; with clojure data

(try
  (throw (ex-info "There was a problem" {:detail 42}))
  (catch Exception e
    (prn (:detail (ex-data e)))))

(let [f (clojure.java.io/writer "/tmp/new")]
  (try
    (.write f "some text")
    (finally
      (.close f))))

; Can be written
(with-open [f (clojure.java.io/writer "/tmp/new2")]
  (.write f "some taaaaext"))

