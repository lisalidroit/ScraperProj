(ns clojure-http.core
  (:require [org.httpkit.server :refer [run-server]]
            [clj-time.core :as t]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.page :refer [html5 include-js include-css]]
            [hiccup.form :refer [form-to text-area submit-button]]
            ))

(defn get-time
  []
  (let [response {:status  200
                  :headers {"Content-Type" "text/html"}
                  :body    (str (t/time-now))}]
    response))

(defn render-form
  "Render a simple HTML form page."
  []
  (html5 [:head
          [:meta {:charset "UTF-8"}]]
         [:body
          (form-to [:post "/"]
                   (text-area {:cols 80
                               :rows 10} "content")
                   [:div]
                   (submit-button "Paste!"))]))
(defn app [req]
  (GET "/" [] (render-form))
           (GET "/get-time" [] (get-time))
           (route/not-found "<h1>Page not found</h1>"))


(defn -main [& args]
  (run-server app {:port 8080})
  (println "Server started on port 8080"))
