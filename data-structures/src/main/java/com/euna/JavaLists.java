package com.euna;

import java.util.ArrayList;
import java.util.List;

public class JavaLists {
    public static void main(String[] args) {
        //immutable list
        List<String> immutableList = List.of("Jin", "Mugen");
        System.out.println(immutableList);

        //Array List
        List<String> names = new ArrayList<String>();
        names.add("Jin");
        names.add("Mugen");
        System.out.println(names);

        names.forEach(System.out::println);

        for(String s: names)
            System.out.println(s);

        for (int i = 0; i < names.size() ; i++) {
            System.out.println(names.get(i));
        }
    }
}
