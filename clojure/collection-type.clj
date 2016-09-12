(defn collection-type [col] (
	cond 
	(vector? col) ":vector" 
	(list? col) ":list" 
	(map? col) ":map")
)
(println "collection-type" (collection-type '(1 2 3)))