# Design Principles

## DRY
Don't repeat yourself
## KISS
Keep it stupid, simple

# Object-Oriented Design Principles Guide
## Encapsulate What Changes
- Identify the aspects that vary and separate them from what stays the same
## Favor Composition over Inheritance
- has-a relationship should be preferred over is-a relationship
## Loose Coupling
- interacting components should be independent of each other
## Programming for Interface, not implementation
- Suppose, you are making a database client class, instead of making a concrete class designed to access Postgres, the interface should have the basic methods and specific DB implementations should implement the interface.
## Delegation
- delegate it to the respective class
- like equals() method in java
- helps avoid duplicate code
  
# SOLID
## Single Responsibility Principle<br>
- class should have only one reason to change<br>
## Open Closed Principle<br>
- open for extension, closed for modifications<br>
- to add a new implementation, approach this in 2 ways.
1. extend the existing functionality to a new class, and add the implementations there
2. Use composition to accept new behaviors <br>
## Liskov Substitution Principle<br>
- Should not depend on methods it does not use
- Substituting subtype for base class should not break the code
## Interface Segregation Principle<br>
- components of an interface should be highly relatable, if not separate them<br>
## Dependency Injection Principle<br>
- use abstraction instead of concrete implementation
- High-level modules should not depend on the low-level module but both should depend on the abstraction

# Pillars of OOP<br>
## Abstraction<br>
-the process of simplifying complex reality by modeling classes based on the essential properties and behaviors while hiding the unnecessary details<br>
## Inheritance<br>
-allows you to create a new class (subclass or derived class) by inheriting properties and behaviors (fields and methods) from an existing class (superclass or base class).<br>
-It supports the concept of code reuse and is used to establish an "is-a" relationship between classes.<br>
## Encapsulation<br>
-bundling data (attributes or fields) and methods (functions) that operate on that data into a single unit<br>
## Polymorphism<br>
-the ability of objects to take on multiple forms<br>

# Has-A vs Is-A
-Neither is inherently "better" than the other<br>
## Is-A Relationship (Inheritance)
-Use the "Is-A" relationship when you want to model a hierarchical relationship where one class represents a more specific or specialized version of another class<br>
- Inheritance is useful for code reuse and to establish a clear taxonomy of classes<br>
## Has-A Relationship (Composition)
-Use the "Has-A" relationship when you want to create complex objects by combining simpler objects<br> -Composition allows for greater flexibility and can represent more diverse and flexible relationships between classes<br>
