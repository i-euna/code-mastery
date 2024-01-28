package com.euna;

import java.util.Arrays;

public class JavaArrays {
    public static void main(String args[]) {
        String[] names = new String[3];
        names[0] = "Jin";
        names[1] = "Mugen";

        System.out.println("Names: " + Arrays.toString(names));

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        for(String name : names)
            System.out.println(name);

        int[] nums = {100, 200};
        Arrays.stream(nums)
              .forEach(System.out::println);
    }
}
