(ns functional-design.test.gossip-test
  (:require [clojure.test :as t]))

(defn make-driver [name]
  {:name name})

(t/run-tests)

(t/deftest gossip-test
  (t/testing "とりあえず"
    (t/is (= 1 1)))

 	(t/testing "driverつくる"
   	(t/is (= {:name "driver1"} (make-driver "driver1")))))

