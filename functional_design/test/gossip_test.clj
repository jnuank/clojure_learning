(ns functional-design.test.gossip-test
  (:require [clojure.test :as t]
            [functional-design.src.gossip :refer :all]))

(t/run-tests)

(t/deftest gossip-test
  (t/testing "driverつくる"
    (t/is (= {:name "driver1" :route [:stop1] :rumors #{:rumors1} }
             (make-driver "driver1" [:stop1] #{:rumors1 }))))

  (t/testing "ドライバーの1つ目に停まるバス停1"
    (let [driver (make-driver "driver1" [:stop1] #{:rumors1})
          world [driver]
          new-world (drive world)]
      (t/is (= 1 (count new-world)))
      (t/is (= :stop1 (-> new-world first :route first)))
      ))
  
  (t/testing "ドライバーの2つ目に停まるバス停2"
    (let [driver (make-driver "driver1" [:stop1 :stop2] #{:rumors1})
          world [driver]
          new-world (drive world)]
      (t/is (= 1 (count new-world)))
      (t/is (= :stop2 (-> new-world first :route first)))
      ))
  
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
    

(let [drivers []]
  (t/is (= {:stop1 [{:name "driver1" :route [:stop1]}
                   {:name "driver2" :route [:stop1]}]
           :stop2 [{:name "driver3" :route [:stop2]}]}
          (get-stops drivers))))))


