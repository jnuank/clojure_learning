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

(assoc scores "Sally" 0)

(assoc scores "Bob" 0)

(dissoc scores "Bob" "Fred" "Angela" "aaa")

; value取得
(get scores "Angela")

(scores "Fed")

(def bad-lookup-map ["a" "B"])

(bad-lookup-map 1)

(keys scores)

; 2つのシーケンスからkeyとvalueつくるやつ
players
(zipmap players (repeat 0))


(doc repeat)

(zipmap [1 2 3] '("a" "b" "c" "d"))

(zipmap scores (repeat 0))

scores

(into {} (map (fn [player] [player 0]) players))
(into {} (map #(vector % 0) players))

(map #(println %) players)
players

(reduce (fn [m player]
          (assoc m player 0)
          {
           players}))

; 動きがよくわからん reduce
(reduce (fn [m player] (assoc m player 0)) {} players)

(doc reduce)


(def person
  {:first-name "Kelly"
   :last-name "Keen"
   :age 32
   :occupation "Programmer"})

(get person :occupation)

(person :occupation)

(:occupation person)

; 存在しないkeyの場合はデフォ値も使える
(:hoge person "default")

; ネストされたmap

(def company
  {:name "WidgetCo"
   :address {:street "123 Main St"
             :city "Springfield" 
             :state "IL"}})

(get-in company [:address :city])

; record
(defrecord Person [first-name last-name age occupation])

; ネストはこんな感じ
(defrecord Address [street city state])
(defrecord Company [name address])

(->Company)

(def company (->Company "company1"
                        (->Address "street" "city" "state")))

(def company-other (Company. "company1"
                        (Address. "street" "city" "state")))

company-other

company
; これが一つの関数として呼び出せる
(->Person)

(def kelly (->Person "Kelly" "Keen" 32 "Programmer"))

(:first-name kelly)
(kelly :first-name) ;これだけエラー
(get kelly :first-name)

(person :first-name)
(:first-name person)
(get person :first-name)