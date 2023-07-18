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

        Person[] personArray = {
                new Person("Jin", 10, "student"),
                new Person("Mugen", 15, "student"),
                new Person("Momo", 20, "worker"),
                new Person("So", 30, "worker"),
        };
        List<Person> listOfPersons = new ArrayList<>(Arrays.asList(personArray));

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

        List<String> names = listOfPersons.stream()
                .map(person -> person.name)
                .collect(Collectors.toList());
        System.out.println("Names: " + names);

        //Filter
        List<Integer> evens = listOfIntegers.stream()
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println("Even integers " + evens);

        List<String> longWords = listOfStrs.stream()
                .filter(isLongerThan3)
                .collect(Collectors.toList());
        System.out.println("Long words " + longWords);

        List<Person> olderThan15 = listOfPersons.stream()
                .filter(person -> person.age > 15)
                .collect(Collectors.toList());
        System.out.println("Older than 15: " + olderThan15);

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

        Integer combinedAge = listOfPersons.stream()
                        .map(person -> person.age)
                        .reduce(0, getSum);
        System.out.println("Older than 15: " + combinedAge);

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

        //combine list
        Integer totalStudentAge = listOfPersons.stream()
                .filter(person -> person.profession == "student")
                .map(student -> student.age)
                .reduce(0, (acc, x) -> acc + x);

        Long noOfStudent = listOfPersons.stream()
                .filter(person -> person.profession == "student")
                .collect(Collectors.counting());
        float avgAgeOfStudents = totalStudentAge / noOfStudent;
        System.out.println("Average student age: " + avgAgeOfStudents );
        Integer totalWorkerAge = listOfPersons.stream()
                .filter(person -> person.profession == "worker")
                .map(student -> student.age)
                .reduce(0, (acc, x) -> acc + x);

        Long noOfWorker = listOfPersons.stream()
                .filter(person -> person.profession == "worker")
                .collect(Collectors.counting());
        float avgAgeOfWorkers = totalWorkerAge / noOfWorker;
        System.out.println("Average student age: " + avgAgeOfWorkers );

        Map<String, Integer> averageAgeMap = listOfPersons.stream()
                .collect(Collectors.groupingBy(
                        person -> person.profession
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                                (entry) -> entry.getKey(),
                                (entry) -> entry.getValue()
                                        .stream()
                                        .map((person) -> person.age)
                                        .reduce(0, (acc, x) -> acc + x) / entry.getValue().size())
                );
        System.out.println("Average age map: " + averageAgeMap );


        //parallel streams - increases performance using multiple thread
        List<String> processedWords = listOfStrs.parallelStream()
                .map(str -> {
                    System.out.println("To Uppercase " + str);
                    return str.toUpperCase();
                })
                .collect(Collectors.toList());

        System.out.println("Processed words: " + processedWords );
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
