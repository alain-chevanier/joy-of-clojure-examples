(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot"))

(println "Cleanliness is next to godliness")


(def region-data-3
  {:region/postcode "12345"})

(:region/postcode region-data-3)

;; C-c l g

(defn make-train-sound
  ""
  []
  (println "Choo Choo!"))

; (make-train-sound)

(def my-object {:prospect/id 1 :prospect/name "Alain"})

(defn destructuring-test
  ""
  [{:prospect/keys [id name]}]
  (println "prospect data" id ", " name))

(destructuring-test my-object)

(def nested-obj {:prospect {:id 1 :name "Ricchy!!!!"}})

(println "My name is " (get-in nested-obj [:prospect :name]))

(defn greet-person
  [person]
  (str "Hello " person))

(println (greet-person "Sergio!!"))



(defn routing-actions
  [origin destination at-origin?]
  (let [default-action #{:route-prospect}]
    (if (= origin destination)
      default-action
      (-> default-action
          (conj :transfer-prospect)
          (#(if at-origin? (conj % :map-cpf-to-shard) %))))))

(defn- add-shardings-by-feature-flag-aux [initial-action feature-flags]
  (loop [ff-pairs (seq feature-flags)
         action initial-action]
    (if (empty? ff-pairs)
      action
      (recur (rest ff-pairs) (conj action (second (first ff-pairs)))))))

(defn- prospect-needs-to-be-remapped? [action]
  (contains? action :map-cpf-to-shard))

(defn add-shardings-by-feature-flag
  [action shardings-by-feature-flag]
  (if (prospect-needs-to-be-remapped? action)
    (add-shardings-by-feature-flag-aux action shardings-by-feature-flag)
    action))

(let [calculated-action (routing-actions :s0 :s1 true)
      sharings-by-feature-flag {:shard-map-by-email? :map-email-to-shard}]
  (add-shardings-by-feature-flag calculated-action sharings-by-feature-flag))

;; (add-shardings-keys-by-feature-flags #{:route-prospect} {:shard-map-by-email? :map-email-to-shard})


(defn builder
  [name key value]
  {:pre [name]}
  {:customer name
   :key key
   :value value})

(def all-elems (->> (all-ns)
                    (filter #(re-matches #"clojure-noob\.*" (str %)))
                    ))
