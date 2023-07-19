package com.euna.programming.functional;

import com.euna.programming.functional.custom.TriFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdvancedConcepts {
    public static void main(String[] args) {
        //partial application
        TriFunction<Integer, Integer, Integer, Integer> add =
                (x, y, z) -> x + y + z;

        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial =
                (x) -> (y, z) -> add.apply(x, y, z);

        BiFunction<Integer, Integer, Integer> add5 =
                addPartial.apply(5);

        System.out.println(add5.apply(6, 7));

        //currying - a special case for partial application
        Function<Integer, Function<Integer, Function<Integer, Integer>>> addPartialCurrying =
                (x) -> (y) -> (z) -> add.apply(x, y, z);
        Function<Integer, Function<Integer, Integer>> add5Currying =
                addPartialCurrying.apply(5);
        Function<Integer, Integer> add5and6 = add5Currying.apply(6);
        Integer sum = add5and6.apply(7);
        System.out.println(sum);

        //recursion
        countDown(5);
        countUp(1);

        //composition
        Function<Integer, Integer> times2 = x -> x * 2;
        Function<Integer, Integer> minusOne = x -> x - 1;

        Function<Integer, Integer> times2minus1 = minusOne.compose(times2);
        Function<Integer, Integer> times2minus1Again = minusOne.andThen(times2);

        System.out.println(times2minus1.apply(5));
        System.out.println(times2minus1Again.apply(5));

        //another composition
        Streams.Person[] personArray = {
                new Streams.Person("Jin", 10, "student"),
                new Streams.Person("Mugen", 15, "student"),
                new Streams.Person("Momo", 20, "worker"),
                new Streams.Person("So", 30, "worker"),
        };
        List<Streams.Person> listOfPersons = new ArrayList<>(Arrays.asList(personArray));

        Function<Person, String> getName = person -> person.name;
        Function<String, String> reverse = str -> new StringBuilder(str).reverse().toString();
        Function<String, String> upperCase = str -> str.toUpperCase();

        Function<Person, String> getReverseUppercaseName =
                getName.andThen(reverse).andThen(upperCase);

//        List<String> results = listOfPersons
//                .stream()
//                .map(getReverseUppercaseName)
//                .collect(Collectors.toList());
    }

    static void countDown(int x) {
        if(x==0) {
            System.out.println("Done");
            return;
        }
        System.out.println(x);
        countDown(x-1);
    }

    static void countUp(int x) {
        if(x>10) {
            System.out.println("Done");
            return;
        }
        System.out.println(x);
        countDown(x+1);
    }

    static class Person {
        public String name;
        public Integer age;

        public String profession;
        public Person(String name, Integer age, String profession) {
            this.name = name;
            this.age = age;
            this.profession = profession;
        }
    }
}
