# Functional Programming In Java

## Table of Contents
- [Streams](#streams)
- [First Class Function](#first-class-function)
- [Advanced Concepts](#advanced-concepts)

## Streams
### Concepts
- **Immutability** means once a data structure is created, its value cannot be changed. Instead of updating the state, we create new instances of the data structure
- **Higher order functions** can take other functions as parameters or return functions as results

### Java Streams
- sequence of elements that can be processed parallelly or sequentially
- stream will not change the original data structure
- Stream has:
  - **Source:** data source
  - **Aggregate Operations:** Using the map, filter, reduce, etc operations complex manipulations can be written in a functional way
  - **Pipeline:** Pipelines can be formed when operations on a stream are chained together
  - **Intermediate and Terminal Operations:** Intermediate operations return a new stream, terminal operations product result/side effect
  - **Lazy Evaluation:** Operations are only evaluated when a terminal operation is invoked, this makes the performance better.

[Example Usage](https://github.com/Euna-Islam/code-mastery/blob/main/functional-programming/src/main/java/com/euna/programming/functional/Streams.java)

## First Class Function
- **First-class functions** let Java treat functions as first-class citizens so that they can be treated as any other data type. So functions can be assigned to variables, passed as arguments, and returned as values from functions
- **Lambda expression** is a way to represent an anonymous function that can be defined "on the fly" right where it is needed.

[Example Usage](https://github.com/Euna-Islam/code-mastery/blob/main/functional-programming/src/main/java/com/euna/programming/functional/FirstClassFunction.java)

## Advanced Concepts
- **Partial Application** means changing a function's number of arguments and creating a function with fewer arguments
- **Currying** is a special case of partial application. here a function with multiple arguments is converted to a sequence of functions each having 1 argument
- **Composition** is combining 2 or more functions to produce a new function
- **Purity** means a function should not have any side effect(change external state) and will always produce the same output for a particular input
  
[Example Usage](https://github.com/Euna-Islam/code-mastery/blob/main/functional-programming/src/main/java/com/euna/programming/functional/AdvancedConcepts.java)
