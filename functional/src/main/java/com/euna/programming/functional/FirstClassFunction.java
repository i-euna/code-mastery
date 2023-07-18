package com.euna.programming.functional;

import com.euna.programming.functional.custom.NoArgFunction;
import com.euna.programming.functional.custom.TriFunction;

import java.util.function.Function;
import java.util.function.BiFunction;

public class FirstClassFunction {
    public static void main(String[] args) {
        //using function interface
        Function<Integer, Integer> doubleFunc = Calculator::add2;
        Integer result = doubleFunc.apply(5);
        System.out.println("Double of 5 : " + result);

        //Lambda expression
        Function<Integer, Integer> tripleFunc =
                x -> result * 3;
        System.out.println("Triple of 3" + tripleFunc.apply(3));
        Function<String, Integer> stringLenFunc = (str) -> {
                Integer len = str.length();
                return len;
        };
        System.out.println("Length of string-Hello is " + stringLenFunc.apply("Hello"));

        //Bifunction, Lambda
        BiFunction<Integer, Integer, Integer> addFunc = (x, y) -> {
            Integer addResult = x + y;
            return  addResult;
        };
        System.out.println("Sum of 3 and 4 is " + addFunc.apply(3, 4));

        //Custom
        TriFunction<Integer, Integer, Integer, Integer> add3Func =
                (x, y, z) -> {
                    return x + y + z;
                };
        System.out.println("Sum of 3, 4, 5 is " + add3Func.apply(3, 4, 5));

        NoArgFunction<String> helloFunc = () -> "Hello";

        System.out.println("Testing NoArgs : " + helloFunc.apply());

        //Function as data
        final Boolean IS_DEVELOPMENT = false;
        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT);
        System.out.println("Fake Person Name " + dataLoader.loadPersonFunc.apply().name);

        //Function as argument
        Integer combinedResult = Calculator.combine2and3(Calculator::add);
        System.out.println("Test function as argument " + combinedResult);
        System.out.println("Test function as argument " +
                Calculator.combine2and3((x, y) ->
                    2 * x + 2 * y
                ));

        //returning functions, closure
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> () -> "Hello!";
        NoArgFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());

        Function<Integer, Integer> timesTwo = Calculator.createMultiplier(2);
        Function<Integer, Integer> timesThree = Calculator.createMultiplier(3);

        System.out.println("Times 2 of 3 : " + timesTwo.apply(3));
        System.out.println("Times 3 of 3 : " + timesThree.apply(3));

        //Closure
        NoArgFunction<NoArgFunction<String>> createGateman = () ->
        {
            String name = "Max";
            return () -> "Hello, " + name;
        };
        System.out.println(createGateman.apply().apply());

        //higher order functions
        BiFunction<Float, Float, Float> divideFunc = (x, y) -> x / y;
        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>>
                secondArgCheckFunc =
                (func) -> (x, y) -> {
                    if(y == 0f) {
                        System.out.println("Error: Divide by 0");
                        return 0f;
                    }
            return func.apply(x, y);
        };
        BiFunction<Float, Float, Float> safeDivideFunc = secondArgCheckFunc.apply(divideFunc);
        System.out.println("Divide safe " + safeDivideFunc.apply(10f, 0f));
    }



    static protected class Person {
        private String name;
        private Integer age;
        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
    static protected class DataLoader {
        public final NoArgFunction<Person> loadPersonFunc;

        public DataLoader(Boolean isDevelopment) {
            this.loadPersonFunc = isDevelopment ?
                       this::loadPersonalFake :
                       this::loadPersonalReal;
        }
        private Person loadPersonalReal() {
            System.out.println("Loading person");
            return new Person("Max", 30);
        }

        private Person loadPersonalFake() {
            System.out.println("Loading person");
            return new Person("Fake", -1);
        }
    }

    protected static class Calculator {
        public static Integer add2(Integer x) {
            return  x + 2;
        }
        public static Integer add(Integer x, Integer y) {
            return  x + y;
        }
        public static Integer combine2and3(BiFunction<Integer, Integer, Integer> combineFunc) {
            return combineFunc.apply(2, 3);
        }

        public static Function<Integer, Integer> createMultiplier(Integer y) {
            return (Integer x) -> x * y;
        }
    }
}
