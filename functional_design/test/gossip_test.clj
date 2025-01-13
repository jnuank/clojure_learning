(ns functional-design.test.gossip-test
  (:require [clojure.test :as t]
            [functional-design.src.gossip :refer [make-driver]]))

(t/run-tests)

(t/deftest gossip-test
  (t/testing "とりあえず"
    (t/is (= 1 1)))

  (t/testing "driverつくる"
    (t/is (= {:name "driver1" :route [:stop1] :rumors #{:rumors1} }
             (make-driver "driver1" [:stop1] #{:rumors1 })))))


[:s1]

; driverはnameとrouteとrumorsを持っている

