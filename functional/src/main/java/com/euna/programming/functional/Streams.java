package com.euna.programming.functional;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        String[] stringArray = {"Hello", "Bye", "Hi", "Wow", "Yes", "No"};
        List<String> listOfStrs = new ArrayList<>(Arrays.asList(stringArray));

        //Functions
        Function<Integer, Integer> timesTwo = x -> x * 2;
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Function<Integer, Predicate<String>> checkLength = (minLength) -> {
          return (str) -> str.length() >= minLength;
        };
        Predicate<String> isLongerThan3 = checkLength.apply(3);

        //Map
        List<Integer> doubled = listOfIntegers.stream()
                .map(timesTwo)
                .collect(Collectors.toList());
        System.out.println("Doubled integers " + doubled);

        //Filter
        List<Integer> evens = listOfIntegers.stream()
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println("Even integers " + evens);

        List<String> longWords = listOfStrs.stream()
                .filter(isLongerThan3)
                .collect(Collectors.toList());
        System.out.println("Long words " + longWords);

        //reduce
        System.out.println("Check accumulator");
        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println("acc " + acc + ",x = " + x);
            return result;
        };

        Integer sum = listOfIntegers.stream()
                .reduce(0, getSum);
        System.out.println("Sum with reduce " + sum);

        //collect
        Set<Integer> noDuplicates = listOfIntegers.stream()
                .filter(isEven)
                .collect(Collectors.toSet());
        String joinedWords = listOfStrs.stream()
                .filter(isLongerThan3)
                .collect(Collectors.joining());
        System.out.println("Joined words: " + joinedWords);

        Long wordCount = listOfStrs.stream()
                .filter(isLongerThan3)
                .collect(Collectors.counting());
        System.out.println("Word count: " + wordCount);

        Map<Integer, List<String>> groups = listOfStrs.stream()
                .filter(isLongerThan3)
                .collect(Collectors.groupingBy(
                        word -> word.length()
                ));
        System.out.println("Word Groups: " + groups);

        Map<Boolean, List<String>> partitions = listOfStrs.stream()
                .filter(isLongerThan3)
                .collect(Collectors.partitioningBy(
                        word -> word.length() > 3
                ));
        System.out.println("Word Partition: " + partitions);

    }
}
