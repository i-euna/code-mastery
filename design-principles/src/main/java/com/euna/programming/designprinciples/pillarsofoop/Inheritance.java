package com.euna.programming.designprinciples.pillarsofoop;

/*
 * Inheritance
 */
public class Inheritance {
    class Animal {
        void eat() {
            System.out.println("Animal is eating");
        }
    }

    class Dog extends Animal {
        void bark() {
            System.out.println("Dog is barking");
        }
    }
}
