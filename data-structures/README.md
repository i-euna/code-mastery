# Data Structures

## Table of Contents
- [Arrays](#arrays)
  
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
  - Time: O(1)
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

  
