# Test Problems
- [Test Problems](#test-problems)
    - [Validate Binary Search Tree](#validate-binary-search-tree)
    - [Ransom Note Problem](#ransom-note-problem)
    - [Add two numbers represented in link list](#add-two-numbers-represented-in-link-list)
    - [Find if sum of two exits in a list](#find-if-sum-of-two-exits-in-a-list)
    - [Find first and last index of a number in a sorted array](#find-first-and-last-index-of-a-number-in-a-sorted-array)
    - [Permutation](#permutation)
    - [Sort a list with 3 unique numbers](#sort-a-list-with-3-unique-numbers)
    - [Find longest non-repeating substring](#find-longest-non-repeating-substring)
    - [Queue Reconstruction By Height](#queue-reconstruction-by-height)
    - [Find a non duplicate number in an array](#find-a-non-duplicate-number-in-an-array)
    - [Reverse a link list](#reverse-a-link-list)
    - [Maximum in a stack](#maximum-in-a-stack)
    - [Find Pythagorean Triplet](#find-pythagorean-triplet)
    - [Course Pre-requisites](#course-pre-requisites)
    - [Push Dominoes](#push-dominoes)
    - [Add subtract calculator](#add-subtract-calculator)
    - [Product of Array except self](#product-of-array-except-self)
    - [Non Decreasing Array](#non-decreasing-array)
    - [Unique Number of Occurrences](#unique-number-of-occurrences)
    - [Find word in grid](#find-word-in-grid)
    - [Check if a given string is Palindrome](#check-if-a-given-string-is-palindrome)
    - [Boundary of Binary Tree](#boundary-of-binary-tree)
    - [Least Recently Used cache](#least-recently-used-cache)
    - [Find if linked list has cycle](#find-if-linked-list-has-cycle)
    - [Validate Parentheses in a expression](#validate-parentheses-in-a-expression)
    - [Letter Combinations of a Phone Number](#letter-combinations-of-a-phone-number)
    - [Find first bad version](#find-first-bad-version)
    - [Find Max Consecutive Ones](#find-max-consecutive-ones)
    - [Find Max Consecutive Ones with K changes](#find-max-consecutive-ones-with-k-changes)
    - [Find Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit](./Problems.md#find-longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit)
    - [Find Top K Frequent Elements](#top-k-frequent-elements)
    - [Get container with most water](#get-container-with-most-water)
    - [Find if one can attend all the meetings](#find-if-one-can-attend-all-the-meetings)
    - [Find minimum meeting room required](#find-minimum-meeting-room-required)
    
### Validate Binary Search Tree
*Problem:*\
Given a binary tree, check if the tree is a valid binary search tree(BST).

The Binary Search Tree has the following properties: 
* Each node is represented by a Key, numeric type
* Each node may be at max two child, left and right
* The left subtree of a node(A) contains the nodes which are less than parent node(A)
* The right subtree of a node(A) contains the nodes which are greater than parent node(A)
* Both left and right subtrees must be binary search tree

**Example:**
```
a)          8 
           / \
          6  10
         / \   
        1   5

b)           8 
            / \
           6   10
               / \
              7  12

c)           8 
            / \
           6   10
          / \   
         4   9  

d)          8 
          /   \
         6     10
        / \    / \
       3   7  9  12

e)           8 
            / \
           6   10
          / \   
         4   7  

```

In the above trees a) b) c) are invalid BST. 

Tree notation: `[L N R]`; `L` - Left child, `R` - Right Child, `N` - Parent node

Tree *a)* is invalid BST because left subtree of node `8` *[1 6 5]* is not binary search tree as right child `5` of node `6` is not greater than 6.

Tree *b)* is invalid BST. Right subtree, *[7 10 12]*, of node `8` is BST but all the nodes in right subtree of node `8` is not greater than `8`. Node `7`, left child of node `10` is less than node `8`.

Tree *c)* is invalid BST because all the nodes in left subtree of node `8` is not less than 8. In *[4 6 9]* is a valid BST but node `9` greater than node `8`, which implies that all the nodes in left subtree of node `8` is not smaller than `8`. 

Tree *d)* and *e)* is valid BST.

**Solution:**
For given tree where root node is *R*, 
1. check if left subtree is BST or not, and maintain a range of node values, node with lowest key and node with highest key.
2. check if the right subtree is BST or not? and maintain the same range, lowest and highest keys.
3. if highest key in the range from left subtree is less than the node *R*, and if the lowest key in the range from right subtree is greater than the node *R* then tree is BST.

**Time Complexity:**
In the above approach we are evaluating each node exactly once. The approach is linear time. So the time complexity will be __O(n)__.

**Space Complexity:**
We have to solve this in recursive way, where we will have a validate function where we pass the node. So the space complexity will be based on call-stack for recursive calls. 
Space complexity of recursion process is the depth of the recursion. For binary tree the recursion depth is height of the tree. 
In a balanced binary tree the height of the tree is __log_2(n)__. In worse case we have to go till the lowest level and evaluate each node, then the complexity will be __O(n)__.

[Implementation](./problems/validate_binary_search_tree.py)


### Ransom Note Problem
**Problem**\
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines; otherwise, it will return false.\
Each letter in the magazine string can only be used once in your ransom note.Each letter in the magazine string can only be used once in your ransom note.

Consider the ransom note contains only letters and lowercase. 

**Example**
```
(Ransom Note, Magazine)
('abadc', 'aazzbccdy') - True
('zabd', 'aazzbccdy') - True
('aebe', 'aazebccdy') - False
('aebei', 'aazebecdy') - False
```
**Solutions:**\
Brute Force Approach:\
Take each letter from ransom note string and search in the magazine, if that exists. If exists then update the magazine by removing the letter. In this case the complexity will be
<img src="https://render.githubusercontent.com/render/math?math=O(m * n)"> where *m* is the number of letters in ransom note and *n* is the total number of letters in the magazine. So the complexity will be around <img src="https://render.githubusercontent.com/render/math?math=O(n^2)">.

**Better Approach:**\
We have to read all the characters in the ransom note, so the complexity is <img src="https://render.githubusercontent.com/render/math?math=O(n)">. Now we can optimize the searching in magazine. Store the magazine such a way that a letter can be found at constant time. To do that we can use hash map, scan the magazine once and store the letters and number of occurrence in the hash map.
For every letter in ransom note we check the letter in the hash map:\
    - if not found, then return false\
    - if found, then deduct number of occurrence. If number of occurrence is less than 0 then return false otherwise true.\
For `('abadc', 'aazzbccdy')`
Hash Map will be 
```
{
    a -> 2,
    z -> 2
    b -> 1,
    c -> 2,
    d -> 1,
    y -> 1
}
```
After reading the first letter a:
```
{
    a -> 1,
    z -> 2
    b -> 1,
    c -> 2,
    d -> 1,
    y -> 1
}
```
After reading the 2nd letter :b
```
{
    a -> 1,
    z -> 2
    b -> 0,
    c -> 2,
    d -> 1,
    y -> 1
}
```
After reading the 3rd letter :a
```
{
    a -> 0,
    z -> 2
    b -> 0,
    c -> 2,
    d -> 1,
    y -> 1
}
```
Like these after matching all the letters the magazine will be: 
```
{
    a -> 0,
    z -> 2
    b -> 0,
    c -> 1,
    d -> 0,
    y -> 1
}
```
**Time Complexity:**
<img src="https://render.githubusercontent.com/render/math?math=O(m)"> for creating the hash map and <img src="https://render.githubusercontent.com/render/math?math=O(n)"> for iterating over the ransom note.\
So the complexity will be <img src="https://render.githubusercontent.com/render/math?math=O(m)">+<img src="https://render.githubusercontent.com/render/math?math=O(n)=O(n)">

**Space Complexity:**
Space complexity will depend on the hash map. If there are 26 characters in magazine then the space complexity will be <img src="https://render.githubusercontent.com/render/math?math=O(26)=O(k)=O(1)">

[Implementation](./problems/ransom_note.py)

### Add two numbers represented in link list
Given two link list where each link list represents a number in reverse order. Write a function that takes two numbers in reverse order and represented in link list and returns sum of the numbers represented in link list.

**Example:**
```
 342    -> Link List: 2 -> 4 -> 3
+465    -> Link List: 5 -> 6 -> 4
-----               ----------------
 807                  7 -> 0 -> 8  

```
**Time Complexity:**\
**Space Complexity:**

[Implementation](./problems/add_two_number_in_link_list.py)

### Find if sum of two exits in a list

*Problem:*\
Given a list/array of numbers and a target number. Write a function that returns true if sum of any two number in the list is equal to the target number.

*Example*
```
ar = [2,1,9,5,7,2,4] target number = 5
1 + 4 = 5
The result: true
```

*Solution*
The brute force approach is to check any combination of two number and check their sum with target number.
For the example above: 
```
ar = [2,1,9,5,7,2,4] target number = 5
pick 2
    check sum(2,1) = 3 != 5
    check sum(2,9) = 11 != 5
    check sum(2,5) = 7 != 5
    check sum(2,7) = 9 != 5
    check sum(2,2) = 4 != 5
    check sum(2,4) = 6 != 5

pick 1
    check sum(1,9) = 10 != 5
    check sum(1,5) = 6 != 5
    check sum(1,7) = 8 != 5
    check sum(1,2) = 3 != 5
    check sum(1,4) = 5 = 5  -> RETURN TRUE
    
```

For this approach the time complexity is <img src="https://render.githubusercontent.com/render/math?math=O(n^2)">. For each number in the array you are comparing all the remaining numbers in the list. If you have n numbers then the complexity is <img src="https://render.githubusercontent.com/render/math?math=O(n)*O(n)=O(n*n)=O(n^2)">. The space complexity is 0 as we don't need any more space.
```python
for n1 in ar:
    for n2 in ar:
        if n1 == n2:
            continue
        if n1 + n2 == target:
            return true
```
Linear solution:
Preprocess the numbers in the list/array and keep in a hash map with the index. And for each number we subtract form the target and check if the difference is in the hash map.

**Time Complexity**\
Its a linear approach as we check each number once only. So the time complexity is <img src="https://render.githubusercontent.com/render/math?math=O(n)">.

**Space Complexity**\
We need the space for the hash map, and the size of the hash map will be number of elements in the array. So the space complexity will be  <img src="https://render.githubusercontent.com/render/math?math=O(n)">.

[Implementation - Brute-force](./problems/sum_of_two_numbers_brute_force.py)
[Implementation](./problems/sum_off_two_numbers.py)
[Implementation - Java](./java/src/com/ds/practice/SumOftwo/SumOfTwo.java)

### Find first and last index of a number in a sorted array
**Problem:**\
Given a array/list of sorted number and a target number. Write a function to find the first and last index of the target number in the array.

**Solution:**\
A linear time solution will be read each number in the array and check if current number is the target number. On first occurrence add the index as first index and on the last occurrence add the index as last index. 
First and last occurrence can be determined by: 
* first: if the last number is less than the target number and current number is target number.
* last: if the next number is greater than the target number or null/end of array and current number is the target number.   

The time complexity for this approach will be <img src="https://render.githubusercontent.com/render/math?math=O(n)"> and space complexity will be constant as we need to keep track of low and high index.

We can do better. As the array is sorted we can use binary search which will be efficient as we will be searching on half of the array and sub arrays.
So the idea is to use two binary search, one to find the first index of the target number and the second search for the last index.
**Time Complexity**\
The time complexity will be `log n` for binary search. So for two binary search, the time complexity will be `O(log n) + O(log n) = O(log n)`

**Space Complexity**\
Space complexity will depend on implementation process. For recursion, the complexity will depend on the recursion depth/call stack. 

[Implementation](./problems/sum_off_two_numbers.py)

### Permutation
**Problem:**\
Given a array of random numbers, find all the permutations.

Example: 
```
array = [1, 2, 3]
Permutations:
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
```

**Solution**\
In iterative approach we can solve like this: pick the first number for position 1 from 3 numbers(<img src="https://render.githubusercontent.com/render/math?math=nC_r=3C_1=3">), then pick number for position 2 from remaining 2 number, then pick the remaining number for position 3.
The time complexity is `n!`. `n!=n x (n-1) x (n-2)`

```
                    *
                 /  |  \ 
                1   2    3
               /\   /\   /\
              2  3 1  3 2  1
              |  | |  | |  |
              3  2 3  1 1  2
```

### Sort a list with 3 unique numbers
**Problem:**\
Given a array with 3 unique numbers, sort that list.

Examples:
```
ar = [2, 9, 5, 2, 9, 2, 5]
Sorted array: [2, 2, 2, 5, 5, 9, 9]
```

Solution #1: \
We can just sort it using any sorting algorithm. Quick sort or Merge sort with complexity `n log n`.

Solution #2: \
We can use a data structure to store number of appearance for each number in the list. \
Like for the above list 2 appeared 3 times, 5 and 9 appeared twice. Then sort three unique numbers, that \
will be constant time. We can use a hash map to store the counts. Then reconstruct the list \
from the hash map. This is a linear approach and single pass. As we are using a hash map the \
space complexity will be linear.

Solution #3: \
Solution #2 was good but it uses additional space. Lets try to do the sorting in place \
without using any data structure.

So the idea is to separate two numbers/types of numbers in two end of a linear line/list/array. \
Then we will have the 3rd type in the middle. For this approach we can use two pointers, one will \
point the max index of lowest number in the list and another pointer will point the max index of \
 highest number in the list. 

**Time Complexity**\
The approach is linear so the time complexity will be `n`.

**Space Complexity**\
The sorting will be done in place, no additional space is required.
 
[Implementation](./problems/sort_list_with_3_unique_number.py)



### Find longest non-repeating substring
**Problem:**\
Given a string, find the length of the longest substring without repeating characters.

Examples:
```
String: abrkaabcdefghijjxxx
Length: 10
```

Solution #1: \
Iterative approach: Find create a list of all possible substrings from the string. Which will require 
n(n+1)/2. Then check all the substrings with unique characters, linear computation `O(n)`. So the complexity will be `O(n^3)`.

Solution #2: \
We can use two pointer, one with start position of non repeating sub-string and another one for end position.
When we see find a duplicate character then we move to next start index. The approach is called 
*sliding window*. Time complexity for this approach is `O(n^2)`

```
FIND-MAX-LENGTH(A)
1  size ← A:length
2  result ← 0
3  for i ← 0 to size
4    visited[0 to size] ← [false]
5      for j ← i to size
6        if visited[A[j]] == true 
7          break;
8        else
9          result ← MAX(result, j - i + 1)
10         visited[A[j]] ← true  
11     visited[A[i]] ← false
12 return result

```
Solution #3: \
Try solving the problem in linear time. We will use additional space for this approach.
We will use a hash map data structure to store last seen position of a character. Start pointer/flag 
is set to -1 and end to the first char. Then for each char we will update the start when a duplicate if found, other wise keep increasing end pointer/flag.
For each char we calculate difference between start and end and get maximum of previous result/max-length and current result/max-length.


**Time Complexity**\
The approach is linear so the time complexity will be `n`.

**Space Complexity**\
As we are using a hash map and the size of the hash map will be at max the number of characters in the string. So the space complexity will be `O(n)`.
 
[Implementation](./problems/find_longest_non-repeating_substring.py)
[Implementation](./java/src/com/ds/practice/LongestNonRepeatingSubstring/NonRepeatingSubstring.java)


### Queue Reconstruction By Height
**Problem:**\
Consider a random list of people standing in a queue. If each person is described by a pair of integers `(h, k)`, 
where `h` is the height and `k` is the number of people in front of him, who have a height greater than or equal to `h`. The problem is to define one method to reconstruct the queue.

**Example:**
```
Input:  [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
```
**Solution:** \
A key thing is that a person with higher height won't see the people ahead with lower height than him. 
So we can place the higher height people in a new list and then insert second highest peoples and repeat.
For example:
First place [7,0] and [7,1]
```
[[7,0]  [7,1]]
```
place [6, 1]
```
[[7,0] [6, 1] [7,1]]
```
place [5, 0] [5, 2]
```
[[5, 0] [7,0] [5, 2] [6, 1] [7,1]]
```
place [4, 4]
```
[[5, 0] [7,0] [5, 2] [6, 1] [4, 4] [7,1]]
```

First we need to sort the list using a custom comparator, sort by height then if height is same then sort by person ahead of him. Then check each person and sort them in to a array and return the array.

**Time Complexity**\
Sorting with a good sorting algorithm will require `O(n log n)`, and going through each person will require `O(n)`. \
So time complexity is `O(n log n) + O(n) = O(n log n)`

**Space Complexity**\
We are creating a new list, so space complexity is `O(n)`

[Implementation](./problems/queue_reconstruction.py)


### Find a non duplicate number in an array
**Problem:**\
Given an array of *n* integers, every number in it appears twice expect for one. The problem is to find the one with single occurrence.

Example:
```
Input: [4, 8, 3, 5. 4, 2, 5, 3, 8]
Output: 2

Input: [2, 0, 9, 2. 5, 9, 0]
Output: 5
```

**Solution #1:** \
One approach is to read each number in the list once and store appearance count in a hash map. And then iterate each element in the hash map, the number will single appearance will be the result.
Time complexity will be: `O(n)` for reading each element in the list to create hash map, then `O(n)` for iterating over the hash map. Total complexity is `O(n) + O(n) = O(n)`, linear time. As we have used hash map that will require linear space, `O(n)`.

**Solution #2:** \
Lets try to optimize the solution. We can optimize time complexity as its already linear time. But we can avoid the hash map to remove space complexity.
The key idea is to use `XOR` operation. In `XOR` if the bits are same then results 0 and 1 if bits are opposite.\
`5 XOR 5 = 0 | 101 XOR 101 = 000`\
`5 XOR 2 = 7 | 101 XOR 010 = 111`\
`7 XOR 5 = 2 | 111 XOR 101 = 010`

**Time Complexity**\
`O(n)`

**Space Complexity**\
No additional space is required.

[Implementation](./problems/find_non_duplicate_number.py)

### Reverse a link list
**Problem**\
Given a singly link list. Write a function to reverse the link list

Example
```
Input: 5 -> 8 -> 4 -> 9 -> 0 -> 3
Output: 3 -> 0 -> 9 -> 4 -> 8 -> 5
```

**Solution 1#**\
Visit each node from beginning and push the nodes values in a stack. Then pop values from the stack and create a new link list and keep appending. 
Stack is last-in-first-out(LIFO), reverse the link list. The time complexity is `O(n)` for visiting each node in the link list, and `O(n)` for accessing each element in the stack. So time complexity is `O(n) + O(n)= O(n)`. And space complexity is linear for stack, `O(n)`.

**Solution 2#**\
Time complexity of previous solution is linear, and thats the lower bound as we have to visit each node at-least once. But we will try to do it in one pass by visiting each node exactly once. Also we can optimize space.
The idea is the reverse the links for each node or swap the nodes.

**Time Complexity**\
`O(n)`

**Space Complexity**\
No additional space is required.
[Implementation](./problems/reverse_link_list.py)


### Maximum in a stack
**Problem**\
Given a stack of integers. The task is to design a special stack such that maximum element can be found in `O(1)` time.

Example:
```
Stack: [1, 4, 2, 5, 4]
Max: 5
Pop: 4
Max: 5
Pop: 5
Max: 4
```

**Solution 1#**\
One approach is to go over all the elements in stack and get the maximum, brute-force approach. Time complexity will be `O(n)` and constant space complexity, `O(1)`. Lets try to optimize the time complexity

**Solution 2#**\
In this solution we will use additional space or data structure to hold maximum for each sub stack. We can consider another stack with max.

For example
```
push(1)
Stack: [1]
Max-Stack: [1]

push(2)
Stack: [2, 1]
Max-Stack: [2, 1]

push(1)
Stack: [1, 2, 1]
Max-Stack: [2, 2, 1]

push(3)
Stack: [3, 1, 2, 1]
Max-Stack: [3, 2, 2, 1]  

max(): 3

pop(): 3
max(): 2
Stack: [1, 2, 1]
Max-Stack: [2, 2, 1]
```

**Time Complexity**\
`O(n)`

**Space Complexity**\
`O(n)`

[Implementation](./problems/maximum_in_stack.py)


### Find Pythagorean Triplet
**Problem**\
Given an array of integers, write a function that returns true if there is a triplet *(a, b, c)* that satisfies `a^2+b^2=c^2`.

**Solution #1**\
We can loop over the array three times to get all possible combination of the triplets.
```python
for a in ar
    for b in ar
        for c in ar
            if a^2 + b^2 == c^2
                return true 
```
Time complexity for this brute-force approach is `O(n^3)` and constant space complexity `O(1)`.

**Solution #2**\
We can optimize a little by solving the problem in `O(n^2)`. The idea is to use set or hash map data structure to store squared value.
```
sq <-[n ^ 2]
for a in ar
    for b in ar
        if a^2 + b^2 in sq
            return true
```

**Time Complexity**\
`O(n^2)`

**Space Complexity**\
`O(n)`

[Implementation](./problems/maximum_in_stack.py)

### Course Pre-requisites
Give a list of courses and pre-requisites, determine if courses can be completed.

**Example:**
```
1. Number of courses: 2, Pre-requisites: [[1,0]]
2. Number of courses: 2, Pre-requisites: [[1,0], [0,1]]
```
In example `1.` there are two courses and course `1` has a pre-requisite course `0`. In this case pre-requisites are valid.
But in example `2.` number of coursed are 2, and course `1` has pre-requisite of course `0` and course `0` has pre-requisite of course `1`.
So you can't take course `1` without completing course `0`, and can't take course `0` without completing course `1`. So the one can't complete the courses.

**Solution:**\
We can create a directed graph, where the courses represent the nodes and edges represents the edge.
If there is any cycle in the graph then the courses can't be completed. So we reduced the problem 
to graph problem and the target is to find a cycle in the graph. If there is no cycle then
course pre-requisites set correctly and courses can be completed.

We can create a data structure such that each node has a list of edges where it goes to.
```
| 0 [1]
| 1 [0, 2, 3]
| 2 [3]
| 3 []

```

**Time Complexity**\
`O(n)`

**Space Complexity**\
`O(n)`

[Implementation](./problems/course_prerequisite.py)

### Push Dominoes
There are *n* dominoes placed horizontally. Each domino is placed vertically upright.
Then push some of the dominoes either to the left or to the right. Each domino that is falling to the left pushes the adjacent domino on the left and dominoes falling to the right push their adjacent dominoes standing on the right.
A vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

Given a string *S* representing the initial state. *S[i] = 'L'*, if the *i-th* domino has been pushed to the left; *S[i] = 'R'*, if the *i-th* domino has been pushed to the right; *S[i] = '.'*, if the *i-th* domino has not been pushed.
Return a string representing the final state. 

**Example:**\
Input: ".L.R...LR..L.."\
Output: "LL.RR.LLRRLL.."

**Solution:**\
We can use two passes. In first pass we will add impacts of Left push then in next pass we will add impacts of right push. 
Impacts of each push will be represented by numbers. For left push we will use positive number and at each domino the number will reduce. 
For right push, we will use negative number, and at each domino the number will increment. 

Then we sum both of the impacts. The domino with with positive impact sum will be angled towards left and negative impact sume will angle towards right. And,
domino with impact sum 0 stands string vertically.  

Input: .L.R...LLR.R....LR..
Number of domino: 20
Max value for Left push: 20
Mad value for Right push: -20

First Pass:\
.L.R...LLR.R....LR..\
-19 -20 0  0 -17 -18 -19 -20 -20  0  0  0 -16 -17 -18 -19 -20  0  0 0\

Second Pass:\
.L.R...LLR.R....LR..\
 0   0  0 20 +19 +18 +17   0   0 20 19 20 +19 +18 +17 +16   0 20 19 17
 
Sum:\
  -19 -20 0  0 -17 -18 -19 -20 -20  0  0  0 -16 -17 -18 -19 -20  0  0 0\
   0   0  0 20 +19 +18 +17   0   0 20 19 20 +19 +18 +17 +16   0 20 19 17\
= -19 -20 0 20 +2   0  -2  -20 -20 20 19 20 +3  +1  -1  -3  -20 20 19 17\
 L   L  . R  R   .   L    L   L   R  R  R  R   R   L   L   L  R   R  R
 
Output: LL.RR.LLLRRRRRLLLRRR

**Time Complexity**\
Here we are doing two pass, each of them are linear. So, the time complexity is *O(2n)*=*O(n)*. It's linear.

**Space Complexity**\
We need to store the push effect numbers for each pass, space complexity will be also *O(2n)*=*O(n)*.

[Implementation](./problems/push_dominoes.py)


### Add subtract calculator
Problem:
Given a math expression in string that contains plus, minus operation, parentheses and digits. The porblem is to parse the string, evaluate the expression and return result.

**Solution:**\
We need to read each character one at a time and process it. Process will be different for operators, numbers and parentheses. 
We need to remember previous operator. 

Here we will use stack. First we will do reverse of the expression. Then read each character from the expression.
We will form operand using the digits and push to stack if there is a non-digit character.
We will push everything in stack except '('. For a expression, 
```
Expression: 5 + (12 - 3) + 1
Reverse: 1 + )3 - 21( + 5
1 - update operand
' ' - do nothing
+ - push operand and sign to stack, and reset operand | stack = [+, 1]
) - push to stack | stack = [), + 1]
3 - set operand to 3
' ' - do nothing
- - push operand and sign to stack, and reset operand | [-, 3, ), + 1]
' ' - do nothing
2 - set operand to 2
1 - update operand to 10+2 = 12
( - push operand to stack.This is end of an sub-expression, now evaluate the expression in stack until ')'
    stack = [12, -, 3, ), + 1]
    12 - 3 = 9
    result is 9, now remove ')' from stack and push result in stack.
    stack = [9, +, 1]
```

Finally, evaluate the remaining elements in the stack.

**Time Complexity**\
As we are reading each character once only, the time complexity is *O(n)*.
 
**Space Complexity**\
As we are using stack, so space complexity will be *O(n)* 


[Implementation](./problems/calculator.py)


### Product of Array except self
Given an array *nums* of *n* integers where *n > 1*,  return an array output such that *output[i]* is equal to the product of all the elements of nums except *nums[i]*.
For example:\
Input array is [4, 5, 9, 3]\
Output should be [135, 108, 60, 180]\

**Solution:**\
We can use extra space to store product of all the elements in the left except current one in one array. 
Similarly, store product of all the elements in right except current in another array. Then for each position/item we 
multiply product of left array and product of right array. 

**Time Complexity**\
There are two loops, the complexity is *O(2n)* = *O(n)*.

**Space Complexity**\
As we are using three arrays, the space complexity is *O(3n)=O(n)*

[Implementation](./problems/product_of_array_except_self.py)

### Non Decreasing Array
Given an array *nums* with *n* integers, your task is to check if it could become non-decreasing by modifying at most *1* element.

We define an array is non-decreasing if *nums[i] <= nums[i + 1]* holds for every *i (0-based)* such that *(0 <= i <= n - 2)*.\\
```
Input: [5, 2, 4]
Output: True
change 5 to 1, [1, 2, 4]

Input: [3, 2, 5, 4]
Output: False
There are two downwards scenerio, 3 to 2, 5 to 4. Its posible to fix only one, not both. 
```


**Solution:**\
Here, key points are: `non-decreasing`, `modify at most once`. Non-decreasing means equal or increasing. Let's discard a obvious case: if there are more than one scenario where the numbers are decreasing then return `False`. Because we are allowed to fix only one such occurrence.
So we have to find decreasing pattern in the array, if there is none then return true. Decreasing pattern will be like this: 
```
array[i] > array[i+1] 
or
array[i-1] > array[i]
```

Let's point some decreasing cases and how to fix them:

![Complexity](./images/non-decreasing-array.png) 

In *a)* if start index of decreasing line is the first  element then we can easily plot the stating point in reference to the next.
For example: *[5, 3, 6]*, so we just need to move first element less than or equal to the next element, that is [2, 3, 6]

In *b)*, if start index of decreasing line is the last element then we can easily plot the last point in reference to the previous point.
For example: *[2, 5, 3]*, update last point equal to second last point or more than that. *[2, 5, 6]*

If start index of decreasing line is in between first and last element then there could be two cases:
In *c)*, if *[index + 2] >= [index]* then we can fix this case by moving *[index+1]* up equal to *[index + 2]*.
in *d)*, if *[index + 1] >= [index - 1]* then we can fix this case by moving *[index]* down equal to *[index-1]* or *[index+1]*

**Time Complexity**\
This approach is single pass, so time complexity is *O(n)*.

**Space Complexity**\
Constant space

[Implementation](./problems/non-decreasing-array.py)

### Unique Number of Occurrences
Given an array of integers, write a function that returns *true* if and only if the number of occurrences of each value in the array is unique.

For example:
Input: *[2,5,1,2,5,2]*\
Output: *True*\
Occurrence: *1* 1 time, *2* 3 times and *5* 2 times, [1,3,2]

Input: *[2,5,1,2,5,2,3]*\
Output: *False*\
In this example *1* and *3*, both numbers appeared once in the array. 
 
**Solution:**\
We can do this in two pass. In first pass we store occurrences in a hash map. 
In the second pass we loop over the occurrence numbers and check if there is any
duplicate.

**Time Complexity**\
Time complexity is *O(n)*.

**Space Complexity**\
As the solution uses hash map, so the space complexity is *O(n)*

[Implementation](./problems/unique_number_of_occurrences.py)


### Find word in grid
Given a 2D matrix containing letter and a word, task is to find if the word exists in the grid.\
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:
```
2D matrix
[
  ['A','B','D','T'],
  ['C','D','E','S'],
  ['C','G','F','H']
]

Input: ABDEF
Output: True

Input: BDCCGF
Output: True

Input: TSEDCGF
Output: False

Input: BDCCGD
Output: False
```

**Solution**
Diagonal move is not allowed. So available moves are top, bottom, left, right of current postion. 
We will start searching, by row. In a row, if a matching character is found in a column then we check top, bottom, left, right of that position if matches next character. 
Recursively we do the same thing. 
Base case for returning true is when all the characters are found. If a character is matched then we explore all possible moves one by one unless false is returned.
Edge cases are:
Return False if 
*  row, column index is less than 0, or greater than the matrix size.
*  if character at position [row][col] is not equal

**Time Complexity**\
Time complexity is *O(N*3^L)*, where N is the number of cells in the matrix, L is the number of characters in the word.

**Space Complexity**\
*O(L)*, *L* is the length of the word to match.

[Implementation](./java/src/com/ds/practice/wordsearch/SearchWord.java)

### Check if a given string is Palindrome
Given a string, find the longest palindromic substring in the string.

**Bruteforce solution:** Time complexity is *O(n^3)*, constant space.
[Implementation](./java/src/com/ds/practice/LongestPalindrome/LongestPalindromeBF.java)

**Dynamic Programming:** Time complexity is *O(n^2)*, Space complexity is *O(n^2)*.
[Implementation](./java/src/com/ds/practice/LongestPalindrome/LongestPalindromeDP.java)


### Boundary of Binary Tree
Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.  (The values of the nodes may still be duplicates.)


### Least Recently Used cache
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:

* LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
* int get(int key) Return the value of the key if the key exists, otherwise return -1.
* void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

**Solution**:\
We can solve this problem optimally using hash table and doubly linked list. Hash table will help keeping the keys and values that can be found in *O(1)*. 

There will be two nodes, one we call `head` another at the end called `tail`. In between all the nodes will be added and removed.
Most recently used or newly added node will be at the beginning, next node after head. Least recently used node will be at the end of the linked list. 

[Implementation - with Doubly LinkedList](./java/src/com/ds/practice/LRU/LRUCacheDoubleLinkedList.java)\
[Implementation - with Dictionary](./java/src/com/ds/practice/LRU/LRUUsingOrderedDictionary.java)


### Find if linked list has cycle
Given head of a linked list, determine if the linked list has a cycle in it.

**Solution:**\
We can use Hash table to remember which nodes is visted so far. At anypoint if we found current node in the hash table then it means we are visitin the same node again and the link list contains a loop/circle.

For this soloution time complexity is *O(n)* and space complexity is *O(n)*


**Solution:**\
We can use two pointers. Both pointers moves forward but in different speed. One pointer move slow, one step at a time while the other pointer moves faster 2 steps at a time. Eventually fast pointer will meet the slow pointer. 

[Implementation](./java/src/com/ds/practice/LinkedlistCycle/LinkedList.java)

### Validate Parentheses in a expression
Given a string containing just the characters `'(', ')', '{', '}', '[' and ']'`, determine if the input string is valid.

An input string is valid if:
* Open brackets must be closed by the same type of brackets.
* Open brackets must be closed in the correct order.

**Solution:**\
Read each char at a time and push to stack if there is opening of characters. And if there is a closing then pop from the stack.
If the popped character is not closing of same character then the parenthesis is not valid.

**Time complexity**: *O(n)*\
**Space complexity**: *O(n)*

[Implementation](./java/src/com/ds/practice/Parentheses/Parentheses.java) 

### Letter Combinations of a Phone Number
Given a string containing digits from *2* to *9*. For each digit there is a corresponding string containing multiple letters. The task is to return all possible letter combinations that a number could represent.

Lets consider a phone keypad where there are letters for each digit. 
Digit to String mapping

```
"2" ->"abc"
"3" -> "def"
"4" -> "ghi"
"5" -> "jkl"
"6" -> "mno"
"7" -> "pqrs"
"8" -> "tuv"
"9" -> "wxyz"
```

**Example:**
Consider an input "38". Here digit 3 represents "def" and digit 8 represents "tuv". All possible combinations will be:
```
Input: 38
Output: ["dt","du","dv","et","eu","ev","ft","fu","fv"]
```

**Time complexity**: *O(3^N*4^M)* where *N* is the number of digits that corrosponds to 3 letter string, and *M* is the number of digits(`7`,`9`) that corrosponds to 4 letter string.  

**Space complexity**: *O(3^N*4^M)* 

[Implementation](./java/src/com/ds/practice/LetterCombination/LetterCombination.java)


### Find first bad version
Consider a version controle system where each new version get a copy of immidiate oldest version. So the new version contains the things which were there in the immidiate oldest version. Let's mar the versions by number, `1, 2, 3, 4, 5, 6` be a list of versions `1` is the first version and `6` is the last version. If there is a fault in version `3` then the fault will propagate in all later versions unless fixed. 

So the problem is, given n versions [1, 2, ..., n] and find out the first bad/faulty version, which causes all the following ones to be bad. Consider you have an API where you pass the version number and it returns if the version is bad or good. 

**Example** 
```
Given n = 8, and version = 6 is the first bad version.

call isBadVersion(6) -> true
call isBadVersion(5) -> false
call isBadVersion(7) -> true
```

**Solution**:
Brute force approach would be iterating over the range of versions and call `isBadVersion` API. The time complexity will be *O(n)*

To improve the result, we can use Binary search.


**Time complexity**: *O(log n)* 
**Space complexity**: *O(1)* 

[Implementation](./java/src/com/ds/practice/BadVersion/Version.java)

### Find Max Consecutive Ones
Given a binary array, find the maximum number of consecutive 1s in this array.

*Example*
```
Input: [1, 1, 0, 1, 1, 1, 0, 1, 1]
Output: 3
```

**Solution**\
Iterate over the array. Maintain a consecutive 1 sequence counter, and max length of consecutive 1.

**Time complexity**: *O(n)* 
**Space complexity**: *O(1)* 

[Implementation](./java/src/com/ds/practice/MaxConsecutiveOnes/MaxConsecutiveOnes.java)


### Find Max Consecutive Ones with K changes
Given an array of *0*s and *1*s, you are allowed to change up to K values from 0 to 1.
Return the length of the longest (contiguous) subarray that contains only 1s. 

**Solution**\
We can use two pointers, *start*, *end* and variable sliding window approach. 
In a window there will at-most *K* *0s*. If there are more than *K* 0s then we move the 
start pointer one at a time and keep increasing the window size by incrementing *end* pointer.
When there are more than *K* *0s* in the window and current *start* index contains a *0* then we move *start* and add *1* to *K* because we are leaving one zero from the window.

**Time complexity**: *O(n)* 
**Space complexity**: *O(1)* 

[Implementation](./java/src/com/ds/practice/MaxConsecutiveOnes/MaxConsecutiveOnes.java)

### Find Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

Example:
```
Input: nums = [7,4,9,6,7], limit = 3
Output: 3 
Explanation: All subarrays are: 
[7] with maximum absolute diff |7-7| = 0 <= 3. => Max Length = 1
[7,4] with maximum absolute diff |7-4| = 3 <= 3. => Max Length = 2
[7,4,9] with maximum absolute diff |9-4| = 5 > 3. => Max Length = 2
[7,4,9,6] with maximum absolute diff |9-4| = 5 > 3. => Max Length = 2
[7,4,9,6] with maximum absolute diff |9-4| = 5 > 3. => Max Length = 2
[4,9] with maximum absolute diff |4-9| = 5 > 3. => Max Length = 2
.
.
[9,6] with maximum absolute diff |9-6| = 3 <= 3. Max Length = 2
[9,6,7] with maximum absolute diff |9-6| = 3 <= 3. Max Length = 3.

Therefore, the size of the longest subarray is 3.
```
**Solution**:\
Used sliding window with keeping track of maximum and minimum number in the list.

[Implementation](./java/src/com/ds/practice/SubarrayWithAbsoluteDiff/SubarrayWithAbsoluteDiff.java)

### Get container with most water
Given n non-negative integers *a_1, a_2, ..., a_n*, where each represents a point at coordinate *(i, a_i)*. 
*n* vertical lines are drawn such that the two endpoints of the line *i* is at *(i, a_i)* and *(i, 0)*. Find 
two lines, which, together with the *x-axis* forms a container, such that the container contains the most water.

Example:\
Input: height = [3,15,6,2,5,20,8,3,7]\
Output: 60

Input: height = [4,3,2,1,4]\
Output: 16

Input: height = [1,2,1]\
Output: 2

**Solution**:
Brute-force solution will be check each combination of the heights, calculate the area and keep updating the maximum area.
Time complexity will be *O(n^2)*.

To optimize the solution we can use two important idea
* To have a bigger container which may contain more water depends on two factors:
    * container height is not that long but much more wider, or not that wider but much taller. If we look at the area 
    calculation formula, *area = width X height*. So area can be bigger either *width* or *height* is bigger.
* Container height is restricted by the lower height between two sides.

We can use two pointer, one at the beginning and another one at the end or the given heights array.
Then we move each pointer towoards opposite direction, start towards end and end pointer towards start.
We move start pointer to next position if height of current pointer is less than the height of end pointer.
Do the same for end pointer.

**Time complexity**: *O(n)*\
**Space complexity**: *O(1)*\

[Implementation](./java/src/com/ds/practice/ContainerWithMostWater/ContainerWithMostWater.java)


### Find if one can attend all the meetings
Given an array of meeting time intervals consisting of start and end times *[[s1,e1],[s2,e2],...] (si < ei)*, determine if a person could attend all meetings.

Example:
```
Input: [[0,20],[5,10],[15,20]]
Output: false

Input: [[7,11],[3,6]]
Output: true
```

[Implementation](./java/src/com/ds/practice/meetingroom/MeetingRoom.java)


### Find minimum meeting room required
Given an array of meeting time intervals consisting of start and end times *[[s1,e1],[s2,e2],...] (si < ei)*, find the minimum number of conference rooms required. 

Example:
```
Input: [[9, 11], [11, 12], [9, 13], [8, 10]]
Output: 3 

Input: [[9, 11], [7, 9], [11, 12], [12, 13]]
Output: 1 

Input: [[9, 12], [10, 11], [10, 12], [8, 11]]
Output: 4 
```
**Solution**:
The problem is about optimizing number of rooms required to arrange all the meetings. If not optimized then we could have 
assigned a new room to each meeting.

How to optimize the number of rooms ? Reuse the rooms. How to reuse the rooms? To reuse the rooms we need to find rooms which was
occupied before but now free. A meeting room is free or not is identified by the end time.

Use min-heap data structure to store the end time of meetings. The root of the min-heap will be the meeting that will be ending at the earliest.
Before allocating a new room we just need to check the root of the min-heap, if the root of min-heap contains a time which is less than current meeting start time then
that means that there is a room available to reuse/reallocate, otherwise allocate a new room.

**Time complexity**: *O(n log n)*\
**Space complexity**: *O(n)*\

**Solution 2**:
We can use chronological ordering of the meetings. We can split the meeting start and end time in separate array and sort them in ascending order.
We can use two pointers to indicate current start and end times.
For each start time we check the if the end pointer is pointing to a end time which is greater than or equal to start time, then we can reuse the room; otherwise
a new room needs to allocate. 

**Time complexity**: *O(n log n)*\
**Space complexity**: *O(n)*\

[Implementation](./java/src/com/ds/practice/MinMeetingRoom/MinMeetingRoom.java)
