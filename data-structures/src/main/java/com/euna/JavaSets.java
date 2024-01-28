package com.euna;

import java.util.HashSet;
import java.util.Set;

public class JavaSets {
    public static void main(String[] args) {

        Set<TreeType> treeTypeSet = new HashSet<>();
        treeTypeSet.add(new TreeType("Mango"));
        treeTypeSet.add(new TreeType("Pineapple"));
        //duplicate - not allowed
        treeTypeSet.add(new TreeType("Pineapple"));

        System.out.println(treeTypeSet.size());
        treeTypeSet.forEach(System.out::println);
    }

    record TreeType(String genus) {

    }
}
