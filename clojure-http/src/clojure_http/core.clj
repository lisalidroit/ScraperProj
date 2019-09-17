
(ns clojure-http.core
  (:require [org.httpkit.server :refer [run-server]]
            [clj-time.core :as t]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [selmer.parser :refer [render-file render]]
            [ring.util.response :as resp]))

(defn get-time
  []
  (let [response {:status  200
                  :headers {"Content-Type" "text/html"}
                  :body    (str (t/time-now))}]
    response))

(defroutes app
           (GET "/" [] (resp/resource-response "main-page.html" {:root "public"}))
           (GET "/Pages/" [] (resp/resource-response "page2.html" {:root "public/Pages"}))
           (GET "/get-time" [] (get-time))
           (route/not-found "<h1>Page not found</h1>"))


(defn -main [& args]
  (run-server app {:port 8080})
  (println "Server started on port 8080"))

