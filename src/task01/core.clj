(ns task01.core
  (:require [pl.danieljanus.tagsoup :refer :all])
  (:gen-class))

" 1) Find all elements containing {:class \"r\"}.

Example:
[:h3 {:class \"r\"} [:a {:shape \"rect\", :class \"l\",
:href \"https://github.com/clojure/clojure\",
:onmousedown \"return rwt(this,'','','','4','AFQjCNFlSngH8Q4cB8TMqb710dD6ZkDSJg','','0CFYQFjAD','','',event)\"}
[:em {} \"clojure\"] \"/\" [:em {} \"clojure\"] \" · GitHub\"]]

2) Extract href from the element :a.

The link from the example above is 'https://github.com/clojure/clojure'.

3) Return vector of all 10 links.

Example: ['https://github.com/clojure/clojure', 'http://clojure.com/', . . .]
"

(defn foo [param1 param2]
   ((loop [head param1  
           body param2
           res []]
     (if (empty? (next body)) 
       res
       ((if (= (get head 1) {:class "r"})
         (conj res (:href (get (get head 2) 1))))
         (recur (first body) (next body) res))))))

(defn get-links []

  (let [data (parse "clojure_google.html")]
    (foo (first data) (next data))))

(defn -main []
  (println (str "Found " (count (get-links)) " links!")))


