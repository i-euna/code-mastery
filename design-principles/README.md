# Design Principles

# DRY(Don't repeat yourself)

# KISS(Keep it simple)

# Encapsulate What Changes
- Identify the aspects that vary and separate them from what stays the same
# Favor Composition over Inheritance
- has-a relationship should be preferred over is-a relationship
# Loose coupling
- interacting components should be independent of each other
# Programming for Interface not implementation
- Suppose, you are making a database client class, in stead of making a concrete class designed to access Postgres, the interface should have the basic methods and specific DB implementations should 
implement the interface.
# Delegation
- delegate it to the respective class
- like equals() method in java
- helps avoid duplicate code
# SOLID
## Single Resposibility Principle<br>
- class should have only one reason to change<br>
## Open Closed Principle<br>
- open for extension, closed for modifications<br>
- to add a new implementation, approach this in 2 ways.
1. extend the existing functionality to a new class, add the implementations there
2. Use composition to accept new behaviours<br>
## Liskov Substitution Principle<br>
- Should not depend on methods it does not use
- Substituting subtype for base class should not break the code
## Interface Segregation Principle<br>
- components of interface should be highly relatable, if not seperate them<br>
## Dependency Injection Principle<br>
- use abstraction in stead of concrete implementation
- High-level modules should not depend on the low-level module but both should depend on the abstraction

# Pillars of OOP<br>
## Abstraction<br>
## Inheritance<br>
-allows you to create a new class (subclass or derived class) by inheriting properties and behaviors (fields and methods) from an existing class (superclass or base class).<br>
-It supports the concept of code reuse and is used to establish an "is-a" relationship between classes.<br>
## Encapsulation<br>
-bundling data (attributes or fields) and methods (functions) that operate on that data into a single unit<br>
## Polymorphism<br>

# Has-A vs Is-A
