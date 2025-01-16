(ns user
  (:require [clojure.test :as t]
            [functional-design.src.gossip :as gossip]
            [functional-design.test.gossip-test :as gossip-test]))

(defn reset []
  (require '[functional-design.src.gossip :as gossip] :reload)
  (require '[functional-design.test.gossip-test :as gossip-test] :reload)
  :ready)

;; 必要に応じて他のユーティリティ関数を追加
(defn run-tests []
  (t/run-tests 'functional-design.test.gossip-test)) 