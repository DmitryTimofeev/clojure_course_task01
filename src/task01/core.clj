(ns task01.core
  (:require [pl.danieljanus.tagsoup :refer :all])
  (:gen-class))

(defn get-ref [param]
  (if (= (get param 1) {:class "r"})
    (:href (get (get param 2) 1))
    ))

(defn foo [param]
   (loop [head (first param)
          body (next param)
          res []]
     (if (empty? body)
       res
       (do         
         (recur 
          (first body) 
          (next body) 
          (conj res (get-ref head)))))))
   


(defn get-links []
  (let [data (parse "clojure_google.html")]
    (foo data)))


(defn -main []
  (println (str "Found " (count (get-links)) " links!")))

