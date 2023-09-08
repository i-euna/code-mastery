package com.euna.programming.designprinciples.pillarsofoop;

/*
 * Polymorphism
 */
public class Polymorphism {
    //method override
    class Animal {
        void makeSound() {
            System.out.println("Animal makes a sound");
        }
    }

    class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Dog barks");
        }
    }

    //method overloading
    class Calculator {
        int add(int a, int b) {
            return a + b;
        }

        double add(double a, double b) {
            return a + b;
        }
    }


}
