(ns ClojureReact.routes.api-routes
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [clojure.tools.logging :refer [debug]]))

(def ^:private comments (atom [{:id 1388534400000 :author "Pete Hunt" :text "Hey There!"},
                               {:id 1420070400000 :author "Paul O’Shannessy" :text "React is *great*!"},
                               {:id 1420070400001 :author "Paul O’Hara" :text "React is *cool*!"}]))



(defroutes api-routes
  (context "/api" []
    (GET "/comments" []
      (debug "Requesting all Comments...")
      (ok @comments))

    (POST "/comments" {comment :params}
      (debug comment)
      (let [updated-id (assoc comment :id (System/currentTimeMillis))]
        (ok (swap! comments conj updated-id))))))