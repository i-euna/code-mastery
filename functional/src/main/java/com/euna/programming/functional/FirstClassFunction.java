package com.euna.programming.functional;

import java.util.function.Function;
import java.util.function.BiFunction;

public class FirstClassFunction {
    protected static class Calculator {
        public static Integer Double(Integer x) {
            return  x + 2;
        }
    }
    public static void main(String[] args) {
        //using function interface
        Function<Integer, Integer> doubleFunc = Calculator::Double;
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
    }
}
