# Pillars of OOP

## Table of Contents
- [Abstraction](#abstraction)
- [Inheritance](#inheritance)
- [Encapsulation](#encapsulation)
- [Polymorphism](#polymorphism)

## Abstraction
- the process of simplifying complex reality by modeling classes based on the essential properties and behaviors while hiding the unnecessary details<br>

```
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
```

## Inheritance
- allows you to create a new class (subclass or derived class) by inheriting properties and behaviors (fields and methods) from an existing class (superclass or base class).<br>
- It supports the concept of code reuse and is used to establish an "is-a" relationship between classes.<br>

```
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
```

## Encapsulation
- bundling data (attributes or fields) and methods (functions) that operate on that data into a single unit<br>

```
public class Encapsulation {
    class Person {
        private String name;
        private int age;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAge(int age) {
            if (age >= 0) {
                this.age = age;
            }
        }

        public int getAge() {
            return age;
        }
    }

}
```

## Polymorphism
- the ability of objects to take on multiple forms<br>

```
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
```