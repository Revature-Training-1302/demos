package org.example.SetExample;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> dinosaurs = new HashSet<>();
        dinosaurs.add("t-rex"); // the hash value is going to be consistent but not ordered, so this will get a random spot in the underlying
        // hash table
        dinosaurs.add("triceratops");
        dinosaurs.add("velociraptor");
        dinosaurs.add("stegosaurus");
        dinosaurs.add("pteradon");
        dinosaurs.add("pterodactyl");
        System.out.println(dinosaurs);
        System.out.println(dinosaurs.contains("t-rex"));
        System.out.println(dinosaurs.contains("kangaroo"));

        // Iterator is an object that points to the values in a data structure and lets us view all of them:
        Iterator<String> itr = dinosaurs.iterator();
        // while there has a next value
        while(itr.hasNext()) {
            String current = itr.next();
            System.out.println("Dinosaur: " + current);
            System.out.println(current.hashCode());
        }

        List<String> foods = new ArrayList<>();
        Iterator<String> iterator = foods.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // Tree Set:
        TreeSet<String> dinosaurs2 = new TreeSet<>();
        dinosaurs2.add("t-rex"); // the hash value is going to be consistent but not ordered, so this will get a random spot in the underlying
        // hash table
        dinosaurs2.add("triceratops");
        dinosaurs2.add("velociraptor");
        dinosaurs2.add("stegosaurus");
        dinosaurs2.add("pteradon");
        dinosaurs2.add("pterodactyl");

        Iterator<String> iterator2 = dinosaurs2.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
        System.out.println(dinosaurs2.first());
        System.out.println(dinosaurs2.last());
        // because tree sets are sorted, we can't add null value:
        dinosaurs2.add(null);
    }
}
