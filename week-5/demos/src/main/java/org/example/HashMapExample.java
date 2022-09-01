package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        // when we define a hashmap, we have to give the type of the string to the integer
        // keys will be cities and values will be the population of those cities
        HashMap<String, Integer> cityToPopulation = new HashMap<>();

        cityToPopulation.put("Tokyo", 37435191);
        cityToPopulation.put("Delhi", 29399141);
        cityToPopulation.put("Shanghai", 26317104);
        cityToPopulation.put("Sao Paulo", 21846507);
        cityToPopulation.put("Mexico City", 21671908);

        // pass in the key and get the corresponding value
        System.out.println(cityToPopulation.get("Shanghai"));
        // return null because New York City is not in the hash map
        System.out.println(cityToPopulation.get("New York City"));

        // replace and put in the new value:
        cityToPopulation.replace("Tokyo", 40000000);

        // return the keys as a set (keys are unique, just like values in a set):
        Set<String> cities = cityToPopulation.keySet();
        // return the values as a collection:
        Collection<Integer> populations = cityToPopulation.values();

        // print out the map
        System.out.println(cityToPopulation);
        // print out the keys:
        System.out.println(cities);
        // print out the values:
        System.out.println(populations);

        System.out.println("Size before clear: " + cityToPopulation.size());
        cityToPopulation.clear();
        System.out.println("Size after clear: " + cityToPopulation.size());
    }
}
