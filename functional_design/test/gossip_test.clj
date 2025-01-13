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
          new-world1 (drive world)]
      (t/is (= 2 (count new-world1)))
      (t/is (= :stop2 (-> new-world1 first :route first)))
      (t/is (= :stop3 (-> new-world1 second :route first))))))


