(defproject my-project "0.1.0-SNAPSHOT"
  :description "Your project description"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [speclj "3.6.0"]]
  :profiles {:dev {:dependencies [[nrepl "1.0.0"]
                                  [cider/cider-nrepl "0.28.5"]]
                   :plugins [[cider/cider-nrepl "0.28.5"]]}}
  :plugins [[speclj "3.6.0"]]
  :test-paths ["spec"])