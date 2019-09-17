(defproject clojure-http "0.1.0-SNAPSHOT"
  :author "Lisa & Harseerat"
  :description "A simple HTTP server"
  :min-lein-version "2.7.1"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.2.0"]
                 [clj-time "0.14.0"]]
  :main clojure-http.core)
