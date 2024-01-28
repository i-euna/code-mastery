package com.euna;

import java.util.HashMap;
import java.util.Map;

public class JavaMaps {
    public static void main(String[] args) {
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person("Jin"));
        map.put(2, new Person("Mugen"));

        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.get(1));
        System.out.println(map.containsKey(1));
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
    }

    record Person(String name){}
}
