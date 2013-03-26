(ns task01.core
  (:require [pl.danieljanus.tagsoup :refer :all])
  (:gen-class))

(defn nnil? [data]
  (if-not (nil? data)
    true
    false))

(defn get-ref [param]
  (if (= (get param 1) {:class "r"})
    (:href (get (get param 2) 1))))
   
(defn bar [data]
  (if (vector? data)
    (let [x (map get-ref data)]
      (if (nil? x)
        (map bar data)
        (apply concat (conj (map bar data) x))))))

(defn get-links []
  (let [data (parse "clojure_google.html")]
    (filter nnil? (bar data))))


(defn -main []
  (println (str "Found " (count (get-links)) " links!")))

