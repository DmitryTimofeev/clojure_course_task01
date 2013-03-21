(ns task01.core
  (:require [pl.danieljanus.tagsoup :refer :all])
  (:gen-class))

(defn foo [param1 param2]
   (loop [head param1
          body param2
          res []]
     (if (empty? body)
       res
       (if (= (get head 1) {:class "r"})
         (conj res (:href (get (get head 2) 1))))
         (recur (first body) (next body) res))))

(defn get-links []

  (let [data (parse "clojure_google.html")]
    (foo (first data) (next data))))

(defn -main []
  (println (str "Found " (count (get-links)) " links!")))

   (loop [head [1]
          body [2 3 4 2 5 6]
          res []]
     (if (empty? body)
       res
       (if (=  head [2])
         conj res (:href (get (get head 2) 1)))
         (recur (first body) (next body) res)))
"


   (loop [head param1
           body param2
           res []]
     (if (empty? (next body))
       res
       (if (= (get head 1) {:class "r"})
         (conj res (:href (get (get head 2) 1))))
         (recur (first body) (next body) res))))

   (loop [head [1]
           body [2 3 4 5 6]
           res []]
     (if (empty? (next body))
       res
       (recur (first body) (next body) res)))"