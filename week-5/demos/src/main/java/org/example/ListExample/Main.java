package org.example.ListExample;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // lists are generic because we specify the type when we instantiate the object:
        List<String> names = new ArrayList<>();
        // once we define the type in our instance, we can't insert a different type:
        // names.add(1);

        CustomList<String> names2 = new CustomArrayList<String>();
        names2.add("name 1"); // 0
        names2.add("name 1"); // 1
        names2.add("name 1"); // 2
        names2.add("name 1"); // 3
        System.out.println(names2.getSize()); // size is 4, therefore the index we insert into next is 4:
        names2.add("name 1"); // 4
        names2.add("name 1");
        names2.add("name 1");
        names2.add("name 1");
        names2.add("name 1");
        names2.add("name 1");
        names2.add("name 1");
        names2.add("name 1");
        names2.add("name 1");
        System.out.println(names2.getSize());
        System.out.println(names2);
        System.out.println(names2.get(4));
//        System.out.println(names2.get(15));


        CustomList<String> names3 = new CustomLinkedList<>();
        names3.add("Rory");
        names3.add("Zabeer");
        names3.add("Luke");
        System.out.println(names3.toString());
//        System.out.println(names3.get(9));
        System.out.println(names3.getSize());
    }
}
