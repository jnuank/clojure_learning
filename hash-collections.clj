(def players #{"Alice", "Bob", "Kelly"})
(def new-players ["Tim" "Sue" "Greg"])

players

; 追加
(conj players "Fred")

; 削除
(disj players "Bob" "Sal")

; 確認
(contains? players "Kelly")

(conj (sorted-set) "Bravo" "Charlie" "Sigma" "Alpha")


(sorted-set "Bravo" "Charlie" "Sigma" "Alpha")

(sorted-set)

(into players new-players)
(into new-players players)

#{"Alice" "Bob" "Kelly"}
#{"Alice", "Bob", "Kelly"}


(= #{"Alice" "Bob" "Kelly"} #{"Alice", "Bob", "Kelly"})
(def scores {"Fred"  1400,
             "Bob"   1240,
             "Angela" 1024})

scores



scores

(assoc scores "Sally" 0 )

(assoc scores "Bob" 0)

(dissoc scores "Bob" "Fred" "Angela" "aaa")

; value取得
(get scores "Angela")

(scores "Fed")

(def bad-lookup-map ["a" "B"])

(bad-lookup-map 1)