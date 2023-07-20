# Design Principles

## DRY(Don't Repeat)

## Encapsulate What Changes
- Identify the aspects that vary and separate them from what stays the same
## Favor Composition over Inheritance
- has-a relationship should be preferred over is-a relationship
## Loose coupling
- interacting components should be independent of each other
## Programming for Interface not implementation
- Suppose, you are making a database client class, in stead of making a concrete class designed to access Postgres, the interface should have the basic methods and specific DB implementations should 
implement the interface.
## Delegation
- delegate it to the respective class
- like equals() method in java
- helps avoid duplicate code
## SOLID
- Single Resposibility<br>
  class should have only one reason to change<br>
- Open Closed <br>
  open for extension, closed for modifications<br>
  to add a new implementation, approach this in 2 ways.
1. extend the existing functionality to a new class, add the implementations there
2. Use composition to accept new behaviours<br>
=> Liskov Substitution <br>
- substituting subtype for base class should not break the code
=> Interface Segregation <br>
- components of interface should be highly relatable, if not seperate them<br>
=> Dependency Injection <br>
- use abstraction in stead of concrete implementation
- High-level modules should not depend on the low-level module but both should depend on the abstraction

##Pillars of OOP<br>
=> Abstraction<br>
=> Inheritance<br>
=> Encapsulation<br>
=> Polymorphism<br>
