(defn fibs-work [n i fs]
  (if (= n i)
    fs
   	(fibs-work n (inc i) (conj fs (apply + (take-last 2 fs))))))

(defn fibs [n]
  (cond
    (< n 1) []
   	(= n 1) [1]
   	:else (fibs-work n 2 [1 1])))

(fibs 5)


(fibs-work 2 2 [1 1])

(conj [1 1] [2])

(concat [1 2] [2])
