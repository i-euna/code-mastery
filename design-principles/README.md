# Design Principles
## Table of Contents
- [KISS](#kiss)
- [DRY](#dry)
- [Encapsulate What Changes](#encapsulate-what-changes)
- [Favor Composition over Inheritance](#favor-composition-over-inheritance)
- [Loose Coupling](#loose-coupling)
- [Programming for Interface, not implementation](#programming-for-interface-not-implementation)
- [Delegation](#delegation)
- [SOLID](#solid)
## KISS
- Keep it stupid, simple
- Not specific to OOP, a good practice in general
- To improve code clarity and maintainability, the design and execution should be simple.

# Object-Oriented Design Principles
## DRY
- Don't repeat yourself
- Don't write duplicate functionality
- Use abstraction to create generalized components
- The opposite of DRY is WET(We Enjoy Typing)
### Violation
- the "eatFood" method is repeated in both the Human and Cow classes
  
```
public class Wet {
    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.eatFood();
        cow.moo();

        Human human = new Human();
        human.eatFood();
        human.shout();
    }
}

public class Human {
   public void eatFood() {
        System.out.println("Eat Food");
   }

   public void shout() {
        System.out.println("Angry man!");
   }
}

public class Cow {
   public void eatFood() {
        System.out.println("Eat Food");
   }
	
   public void moo() {
        System.out.println("Moo");
   }
}
```

### Solution
- introduce a common base class Animal that has the eatFood method

```
public class Dry {
    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.eatFood();
        cow.moo();

        Human human = new Human();
        human.eatFood();
        human.shout();
    }
}
public class Animal {
    public void eatFood() {
        System.out.println("Eat Food");
    }
}
public class Cow extends Animal{
    public void moo() {
        System.out.println("Moo");
    }
}
public class Human extends Animal{
    public void shout() {
        System.out.println("Angry man!");
    }
}
```

## Encapsulate What Changes
- Identify the aspects that may change in the future for change in requirement and separate these from what stays the same
- Encapsulate the varying elements behind abstractions, so changes in the future will not affect the whole system
- In Java, the variables and methods should be private by default
- Increase the access step by step, for example: from private to protected, not private to public

### Violation
- Suppose in a game, you have 5 types of enemies, these types can increase/change in the future

```
public class EnemyGenerator {
	public void createEnemy(String enemyType) {
		 Enemy enemy;
		 if(enemy.equals("IceZombie"))
		   enemy = new IceZombie();
		 else if(enemy.equals("Shooter"))
		   enemy = new Shooter();
		 else if(enemy.equals("Tank"))
		   enemy = new Tank();
		   
		 enemy.findPath();
		 enemy.beginAttack();
	}
}
```

### Solution
- Since the enemy type is prone to change, we seperate it
  
```
public class EnemyFactory {
   public Enemy getEnemy(String enemyType) {
       Enemy enemy;
		 if(enemy.equals("IceZombie"))
		   enemy = new IceZombie();
		 else if(enemy.equals("Shooter"))
		   enemy = new Shooter();
		 else if(enemy.equals("Tank"))
		   enemy = new Tank();
		   
       return enemy;
   }
}

public class EnemyGenerator {
	public void createEnemy(String enemyType) {
		 Enemy enemy = new EnemyFactory().getEnemy(enemyType);
		   
		 enemy.findPath();
		 enemy.beginAttack();
	}
}
```

## Favor Composition over Inheritance
- (if possible)has-a relationship should be preferred over is-a relationship
- while both are ways of reusing already written functionalities, in using composition we are not bound by rigid hierarchies
- composition allows us to switch, mix, and match components which gives better modularity and reusability

### Violation
- let us consider a car that has an engine
- what happens when we want to use a different type of engine
  
```
public class Engine {
    /// Engine logic
    public void convertDieselToEnergy() {}
}
public class Car extends Engine {
    //Car inherits from engine
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.convertDieselToEnergy();  // Inherited from Engine
    }
}
```

### Solution

```
class Engine {
    public void convertFuelToEnergy() {
    }
}
class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
}

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Car car = new Car(engine);
    }
}

```

### Has-A vs Is-A
-Neither is inherently "better" than the other<br>
#### Is-A Relationship (Inheritance)
- Use the "Is-A" relationship when you want to model a hierarchical relationship where one class represents a more specific or specialized version of another class<br>
- Inheritance is useful for code reuse and to establish a clear taxonomy of classes<br>
- can create a tight coupling 
#### Has-A Relationship (Composition)
- Use the "Has-A" relationship when you want to create complex objects by combining simpler objects
- Composition allows for greater flexibility and can represent more diverse and flexible relationships between classes<br>
## Loose Coupling
- Interacting components should be independent of each other
- These components should interact with others through interfaces or abstractions
- Allows the components to evolve independently
### Violation
- Car is creating an instance of engine in it's constructor

```
public class Engine {
    public void convertFuelToEnegy() {
    }
}

public class Car {
    private Engine engine;
    public Car() {
        this.engine = new Engine();
    }
}
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
    }
}
```
### Solution
- Car constructor accepts Engine as parameter
```
public class Engine {
    public void convertFuelToEnegy() {
    }
}

public class Car {
    private Engine engine;
    public Car(Engine engine) {
        this.engine = engine;
    }
}

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Car car = new Car(engine);
    }
}
```

## Programming for Interface, not implementation
- Design systems around interfaces and abstract classes, instead of concrete classes
- Suppose, you are making a database client class, instead of making a concrete class designed to access Postgres, the interface should have the basic methods and specific DB implementations should implement the interface.

### Violation
- here Car is tightly coupled with a specific implementation of engine

```
public class Engine {
    public void convertFuelToEnegy() {
    }
}

public class Car {
    private Engine engine;
    public Car(Engine engine) {
        this.engine = engine;
    }
}
public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Car car = new Car(engine);
    }
}
```

### Solution
- the following allows us to use different type of engine in the Car class
  
```
interface Engine {
    void convertFuelToEnegy();
}

class DieselEngine implements Engine {
    public void convertFuelToEnegy() {
    }
}

class ElectricEngine implements Engine {
    public void convertFuelToEnegy() {
    }
}

class Car {
    private Engine engine;
    public Car(Engine engine) {
        this.engine = engine;
    }
}

public class Main {
    public static void main(String[] args) {
        Engine dieselEngine = new DieselEngine();
        Car dieselCar = new Car(dieselEngine);

        Engine electricEngine = new ElectricEngine();
        Car electricCar = new Car(electricEngine);
    }
}
```

## Delegation
- delegate it to the respective class, don't do everything yourself
- like equals() method in java
- helps avoid duplicate functionality
  
## SOLID
## Single Responsibility Principle(SRP)<br>
- class should have only one reason to change<br>
- if a class has more than one functionality, a coupling is introduced. In case of a change in one functionality, the other may break and will need to be tested too.<br>
## Open Closed Principle<br>
- open for extension, closed for modifications<br>
- already tested code will not be modified and won't need testing<br>
- to add a new implementation, approach this in 2 ways.
1. extend the existing functionality to a new class, and add the implementations there
2. Use composition to accept new behaviors <br>
## Liskov Substitution Principle<br>
- Substituting subtype for base class should not break the code
- A subclass's object methods shouldn't require any parameters, call any variables, or return any data types that aren't returned by methods in the superclass.
## Interface Segregation Principle<br>
- components of an interface should be highly relatable, if not separate them<br>
- class should not implement an interface if it does not use it<br>
- It's like having various tools in a box and every tool has a specific function. If you only need a hammer, you only take the hammer and not a screwdriver. It ensures that classes only use the tools they need.
## Dependency Injection Principle<br>
- use abstraction instead of concrete implementation
- High-level modules should not depend on the low-level module but both should depend on the abstraction
- abstraction should not depend on implementation, it should be the opposite



# Pillars of OOP<br>
## Abstraction<br>
- the process of simplifying complex reality by modeling classes based on the essential properties and behaviors while hiding the unnecessary details<br>
## Inheritance<br>
- allows you to create a new class (subclass or derived class) by inheriting properties and behaviors (fields and methods) from an existing class (superclass or base class).<br>
- It supports the concept of code reuse and is used to establish an "is-a" relationship between classes.<br>
## Encapsulation<br>
- bundling data (attributes or fields) and methods (functions) that operate on that data into a single unit<br>
## Polymorphism<br>
- the ability of objects to take on multiple forms<br>

