# Design Principles

## Table of Contents
- [KISS](#kiss)
- [Delegation](#delegation)
- [DRY](#dry)
- [Encapsulate What Changes](#encapsulate-what-changes)
- [Favor Composition over Inheritance](#favor-composition-over-inheritance)
- [Loose Coupling](#loose-coupling)
- [Programming for Interface, not implementation](#programming-for-interface-not-implementation)
- [SOLID](#solid)
  - [Single Responsibility](#single-responsibility-principle)
  - [Open Closed](#open-closed-principle)
  - [Liskov Substitution](#liskov-substitution-principle)
  - [Interface Segregation](#interface-segregation-principle)
  - [Dependency Inversion](#dependency-inversion-principle)
  
## KISS
- Keep it stupid, simple
- Not specific to OOP, a good practice in general
- To improve code clarity and maintainability, the design and execution should be simple.

## Delegation
- delegate it to the respective class, don't do everything yourself
- like equals() method in java
- helps avoid duplicate functionality

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
  
## SOLID

## Single Responsibility Principle
- class should have only one reason to change<br>
- if a class has more than one functionality, a coupling is introduced. In case of a change in one functionality, the other may break and will need to be tested too.<br>

### Violation
- In this case, Employee class is responsible for both saving the data and reporting attendence

```
public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    public long calculateSalary() {
        //logic for calculating salary
        return 0;
    }
    public void save() {
        //logic for saving data to DB
    }
    public String reportAttendance() {
        //logic for reporting attendence in office
        return "";
    }
}
```

### Solution

```
public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
}
public class AttendenceReporter {
    public String reportAttendance() {
        //logic for reporting attendence in office
        return "";
    }
}
public class Repository {
    public void save() {
        //logic for saving data to DB
    }
}
public class SalaryCalculator {
    public long calculateSalary() {
        //logic for calculating salary
        return 0;
    }
}
```

## Open Closed Principle
- open for extension, closed for modifications<br>
- already tested code will not be modified and won't need testing<br>
- to add a new implementation, approach this in 2 ways.
1. extend the existing functionality to a new class, and add the implementations there
2. Use composition to accept new behaviors <br>

### Violation

```
public class SalaryCalculator {
    public long calculateSalary(String employeeType) {
        if (employeeType == "X") {
            return 100;
        }
        else if (employeeType == "Y") {
            return 80;
        }
        else {
            return 60;
        }
    }
}
```

### Solution

```
public interface SalaryCalculator {
    long calculateSalary();
}
public class DefaultSalaryCalculator implements SalaryCalculator {
    @Override
    public long calculateSalary() {
        return 60;
    }
}
public class EmployeeXSalaryCalculator implements SalaryCalculator {
    @Override
    public long calculateSalary() {
        return 100;
    }
}
public class EmployeeYSalaryCalculator implements SalaryCalculator {
    @Override
    public long calculateSalary() {
        return 80;
    }
}
public class SalaryCalculatorClient {
    public long calculateSalary(SalaryCalculator calculator) {
        return calculator.calculateSalary();
    }
}
```

## Liskov Substitution Principle
- Substituting subtype for base class should not break the code
- A subclass's object methods shouldn't require any parameters, call any variables, or return any data types that aren't returned by methods in the superclass.

### Violation

```
public abstract class Shape {
    public abstract int calcualteArea();
    public abstract int getDiameter();
}
public class Circle extends Shape {
    @Override
    public int calcualteArea() {
        return 0;
    }

    @Override
    public int getDiameter() {
        return 0;
    }
}
class Square extends Shape {

    @Override
    public int calcualteArea() {
        return 0;
    }

    @Override
    public int getDiameter() {
        //don't need this for square
        return 0;
    }
}
```

### Solution

```
public interface Shape {
    public int calculateArea();
}
interface Circle extends Shape {
    int getDiameter();
}
public class CircleImpl implements Circle {
    @Override
    public int calculateArea() {
        return 0;
    }

    @Override
    public int getDiameter() {
        return 0;
    }
}
interface Square extends Shape {
    // Square doesn't have a diameter, so this method is not required here.
}
public class SquareImpl implements Square {
    @Override
    public int calculateArea() {
        return 0;
    }
}
```

## Interface Segregation Principle
- components of an interface should be highly relatable, if not separate them<br>
- class should not implement an interface if it does not use it<br>
- It's like having various tools in a box and every tool has a specific function. If you only need a hammer, you only take the hammer and not a screwdriver. It ensures that classes only use the tools they need.

###Violation

```
public interface Worker {
    void code();
    void manage();
}
public class Developer implements Worker{
    @Override
    public void code() {

    }

    @Override
    public void manage() {
    //developer does not need to manage
    }
}
public class Manager implements Worker{
    @Override
    public void code() {
        //manager does not need to code
    }

    @Override
    public void manage() {

    }
}

```

### Solution

```
public interface Workable {
    void work();
}
public interface Managerial {
    void manage();
}
public class Developer implements Workable{
    @Override
    public void work() {

    }
}
public class Manager implements Managerial{
    @Override
    public void manage() {

    }
}

```

## Dependency Inversion Principle
- use abstraction instead of concrete implementation
- High-level modules should not depend on the low-level module but both should depend on the abstraction
- abstraction should not depend on implementation, it should be the opposite

### Violation

```
class LightBulb {
    private boolean isOn = false;
    public void turnOn() {
        System.out.println("Light bulb is on");
    }

    public void turnOff() {
        System.out.println("Light bulb is off");
    }

    public boolean isOn() {
        return isOn;
    }
}
public class Switch {
    private LightBulb bulb;

    public Switch() {
        this.bulb = new LightBulb();
    }

    public void operate() {
        if (bulb != null) {
            if (bulb.isOn()) {
                bulb.turnOff();
            } else {
                bulb.turnOn();
            }
        }
    }
}
```

### Solution

```
public interface SwitchableDevice {
    void turnOn();
    void turnOff();
    boolean isOn();
}
public class LightBulb implements SwitchableDevice {
    private boolean on = false;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("Light bulb is on");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("Light bulb is off");
    }

    @Override
    public boolean isOn() {
        return on;
    }
}
public class Switch {
    private SwitchableDevice device;

    public Switch(SwitchableDevice device) {
        this.device = device;
    }

    public void operate() {
        if (device != null) {
            if (device.isOn()) {
                device.turnOff();
            } else {
                device.turnOn();
            }
        }
    }
}
```