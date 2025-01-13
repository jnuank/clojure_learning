(ns functional-design.src.gossip)


(defn make-driver [name route rumors]
  {:name name :route route :rumors rumors})

(defn drive [drivers]
  (println drivers)
  drivers)
