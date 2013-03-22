(ns task01.core
  (:require [pl.danieljanus.tagsoup :refer :all])
  (:gen-class))

(defn foo [param]
   (loop [head (first param)
          body (next param)
          res []]

     (if (empty? body)
       res
       (do
         (if (= (get head 1) {:class "r"})
           (conj res (:href (get (get head 2) 1))))
         (recur (first body) (next body) res)))))

(defn get-links []
  (let [data (parse "clojure_google.html")]
    (foo data)))


(defn -main []
  (println (str "Found " (count (get-links)) " links!")))

