package com.euna.programming.designprinciples.pillarsofoop;

/*
 * Abstraction
 */
public class Abstraction {
    //abstract class
    abstract class Shape {
        abstract double calculateArea();
    }

    class Circle extends Shape {
        double radius;

        @Override
        double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    //inheritance
    interface Sound {
        void makeSound();
    }

    class Dog implements Sound {
        @Override
        public void makeSound() {
            System.out.println("Dog barks");
        }
    }

}
