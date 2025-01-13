(ns functional-design.test.gossip-test
  (:require [clojure.test :as t]
            [functional-design.src.gossip :refer :all]))

(t/run-tests)

(t/deftest gossip-test
  (t/testing "driverつくる"
    (t/is (= {:name "driver1" :route [:stop1] :rumors #{:rumors1} }
             (make-driver "driver1" [:stop1] #{:rumors1 }))))

  (t/testing "ドライバーは次のバス停に停まる"
    (let [driver (make-driver "driver1" [:stop1] #{:rumors1})
          world [driver]
          new-world (drive world)]
      (t/is (= 1 (count new-world)))
      (t/is (= :stop1 (-> new-world first :route first)))
      )))



; driverはnameとrouteとrumorsを持っている

(-> (make-driver "driver1" [:s1 :s2 :s3] #{:r1})
    vector
    drive first :route first)

(= :s1 "aa")