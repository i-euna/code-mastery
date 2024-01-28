# Data Structures in Java

## Table of Contents
- [Arrays](#arrays)
- [List](#list)
  - [ArrayList](#arraylist)
- [Stack](#stack)
- [Queue](#queue)
  - [Linked List](#linkedlist)
- [Set](#set)
- [Map](#map)
  
## Arrays
- size is fixed
- data are stored in consecutive memory locations, which makes indexing and retrieval fast
- cache friendly
- since random access is efficient, it's good for scenarios where direct access to an element is needed
- insert/delete in the middle is costly since it needs shifting of elements
- does not support heterogeneous data, all elements have to be of the same type

[Example Usage](https://github.com/Euna-Islam/code-mastery/blob/main/data-structures/src/main/java/com/euna/JavaArrays.java)

### Multi-dimentional Array
- Technically an array of arrays(jagged array)
- the data might not be stored in consecutive location leading to less favourable cache performance

[Example Usage](https://github.com/Euna-Islam/code-mastery/blob/main/data-structures/src/main/java/com/euna/TwoDArrays.java)

### Time/Space Complexity
- Accessing: 
 - Time: O(1)
 - Space: O(1)

- Insert at the End:
  - Time: O(1)(amortized)
  - Space: O(1)
  
- Insert at beginning/middle:
  - Time: O(n)
  - Space: O(1)
  
- delete at the end:
  - Time: O(1)
  - Space: O(1)
  
- delete at beginning/middle:
  - Time: O(n)
  - Space: O(1)
  
- Search (unsorted array):
  - Time: O(n)
  - Space: O(1)
  
- search (sorted array):
  - Time: O(log n)
  - Space: O(1)


## List
- List is a child-interface(extends) of collection, introduces the concept of "order" unlike collection
- allows duplicate like Collection
- unlike Collection, List has index based access(methods- 'get', 'set', 'indexof')

[Example Usage](https://github.com/Euna-Islam/code-mastery/blob/main/data-structures/src/main/java/com/euna/JavaLists.java)

### ArrayList
- implements List
- designed to act like dynamic array, can grow/shrink
- internally uses array, initially allocated with default capacity 10
- since resizing(doubled) is not frequesnt and only when capacity is reached, appending at the end is amortized constant time operation
- random access is efficient because it is actually array access
- insert/delete at specific index needs shifting, so it becomes linear time operation

#### Time/Space Complexity
- Access by index
  - Time: O(1)
  - Space: O(1)
 
- Insert/remove at the end
  - Time: O(1)(amortized)
  - Space: O(1)
 
- Insert/remove in middle
  - Time: O(n)
  - Space: O(1)
 
- Search(linear, unsorted)
  - Time: O(n)
  - Space: O(1)
 
- Search(binary, sorted)
  - Time: O(log n)
  - Space: O(1)
 
- Doubling Size
  - Time: O(n)
  - Space: O(n)

## Stack
- LIFO(Last in first out)
- a subclass of Vector which implements List
- adds operations: push, pop, peek, empty
- slows down performance because some operations are synchronized

[Example Usage](https://github.com/Euna-Islam/code-mastery/blob/main/data-structures/src/main/java/com/euna/JavaStacks.java)

### Time and Space Complexity
- push, pop, peek, empty
  - Time: O(1)
  - Space: O(1)
  
## Queue
- FIFO(First in first out)
- implements Collection interface

### LinkedList
- implements queue and has multiple nodes(doubly-linked)

[Example Usage](https://github.com/Euna-Islam/code-mastery/blob/main/data-structures/src/main/java/com/euna/JavaQueues.java)

### Time and Space Complexity
- poll, peek, add
  - Time: O(1)
  - Space: O(1)
  
- remove
  - Time: O(n)
  - Space: O(1)
  
## Set
- does not allow duplicate elements
- extends Collection(and restricts duplicate elements)

[Example Usage](https://github.com/Euna-Islam/code-mastery/blob/main/data-structures/src/main/java/com/euna/JavaSets.java)

### Time and Space Complexity
for HashSet
- Size
  - Time : O(1)
  - Space : O(1)
  
- Add, remove, contains
  - Time : O(1) average case, O(n) worst case.
  - Space : O(1)
  
## Map
- collection of key-value paair, key is unique
- each key maps to one value
- implemented by HashTable, HashMap, SortedMap

[Example Usage](https://github.com/Euna-Islam/code-mastery/blob/main/data-structures/src/main/java/com/euna/JavaMaps.java)

### HashTable
- HashTable does not allow Null 
- it can face performance issue because it's synchronized

### HashMap
- HashMap allows null, not synchronized. 
- LinkedHashMap extends HashMap, it uses double linked list
- Key goes through hash function and produces hash code
- have to override hashCode() in every class which overrides equals()

### Time and Space Complexity
- put, get, remove
  - Time: O(1) average case, O(n) worst case
  - Space: O(1)

### SortedMap
- has total ordering of elements
