(+ 2 3)

(defn fanctorial [n]
  (if (= n 0)
    1
   	(* n (fanctorial (dec n)))))
