(ns functional-design.src.gossip)


(defn make-driver [name route rumors]
  {:name name :route route :rumors rumors})

(defn- drive-route [driver]
  (let [new-route (vec (concat (rest (:route driver)) [(first (:route driver))]))]
    (assoc driver :route new-route)))

(defn drive [drivers]
  (map #(drive-route %) drivers))

(-> (make-driver "driver2" [:s1 :s2 :s3] #{:r1})
    drive-route)

(let [driver1 (make-driver "driver1" [:s1 :s2 :s3] #{:r1})
      driver2 (make-driver "driver2" [:s2 :s3 :s4] #{:r1})]
  (drive [driver1 driver2]))

(defn get-stops [drivers]
  (->> drivers
       (sort-by :name)
       ; group-by f coll
       ; driversの各要素(driver)に対して匿名関数を適用した結果をキーとして、 
       ; collに対してグループ化する
       (group-by #(first (:route %)))))