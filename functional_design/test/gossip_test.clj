(ns functional-design.test.gossip-test
  (:require [clojure.test :as t]
            [functional-design.src.gossip :refer :all]))


(def test-driver1 (make-driver "driver1" [:stop1] #{:rumors1}))
(def test-driver2 (make-driver "driver2" [:stop1] #{:rumors2}))

(defn test-fixture [f]
  
  (println "test-fixture")
  (f)
  (println "test-fixture end")
  
  )

(t/use-fixtures :each test-fixture)

(t/deftest gossip-test
  ;; (t/is (= test-driver1 (make-driver "driver1" [:stop1] #{:rumors2})))

  ;; (t/is (= world [test-driver1 ]))

  (t/testing "driverつくる"
    (t/is (= {:name "driver1" :route [:stop1] :rumors #{:rumors1}}
             (make-driver "driver1" [:stop1] #{:rumors1}))))

  (t/testing "ドライバーの1つ目に停まるバス停1"
    (let [driver (make-driver "driver1" [:stop1] #{:rumors1})
          world [driver]
          new-world (drive world)]
      (t/is (= 1 (count new-world)))
      (t/is (= :stop1 (-> new-world first :route first)))))

  (t/testing "ドライバーの2つ目に停まるバス停2"
    (let [driver (make-driver "driver1" [:stop1 :stop2] #{:rumors1})
          world [driver]
          new-world (drive world)]
      (t/is (= 1 (count new-world)))
      (t/is (= :stop2 (-> new-world first :route first)))))

  (t/testing "二人のドライバーが停まるバス停"
    (let [driver1 (make-driver "driver1" [:stop1 :stop2] #{:rumors1})
          driver2 (make-driver "driver2" [:stop1 :stop3 :stop2] #{:rumors2})
          world [driver1 driver2]
          new-world1 (drive world)
          new-world2 (drive new-world1)]
      (t/is (= 2 (count new-world1)))
      (t/is (= :stop2 (-> new-world1 first :route first)))
      (t/is (= :stop3 (-> new-world1 second :route first)))
      (t/is (= 2 (count new-world2)))
      (t/is (= :stop1 (-> new-world2 first :route first)))
      (t/is (= :stop2 (-> new-world2 second :route first)))))

  (t/testing "バス停取得"
    (let [drivers #{{:name "driver1" :route [:stop1]}
                    {:name "driver2" :route [:stop1]}
                    {:name "driver3" :route [:stop2]}}]
      (t/is (= {:stop1 [{:name "driver1" :route [:stop1]}
                        {:name "driver2" :route [:stop1]}]
                :stop2 [{:name "driver3" :route [:stop2]}]}
               (get-stops drivers)))))

  (t/testing "噂話をしたらちゃんと共有される"
    (t/is (= [{:name "driver1" :rumors #{:rumor2 :rumor1}}
              {:name "driver2" :rumors #{:rumor1 :rumor2}}]
             (merge-rumors [{:name "driver1" :rumors #{:rumor1}}
                            {:name "driver2" :rumors #{:rumor2}}]))))

  (t/testing "ドライバーが同じバス停に停まったら噂話が共有される"
    
    (let [ d1 (make-driver "driver1" [:stop1 :stop2] #{:rumors1})
          d2 (make-driver "driver2" [:stop1 :stop2] #{:rumors2})
          world [d1 d2] 
          new-world (drive world)
          ] 
      (t/is (= 2 (count new-world)))
      (t/is (= #{:rumors1 :rumors2} (-> new-world first :rumors)))
      (t/is (= #{:rumors1 :rumors2} (-> new-world second :rumors)))))
)

(t/run-tests)