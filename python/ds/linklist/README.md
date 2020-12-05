# Linked List
Linked list is a linear data structure when the memory allocation of the elements in the linked list is not contiguous. 
Each element or `node` in the linked list will have memory allocation based on availability. Each element will contain memory reference of the next node.

## Table of Contents
- [Single Linked list](#single-linked-list)
- [Double Linked list](#double-linked-list)
- [Delete node in a Linked list](#delete-node-in-a-linked-list)
- [Middle of a linked list ](#middle-of-a-linked-list)
- [Find loop in a singly link list](#find-loop-in-a-singly-link-list)
- [Remove loop from single link list if present](#remove-loop-from-single-link-list-if-present)
- [Remove n-th node from end of linked list](#remove-n-th-node-from-end-of-linked-list)
- [Merge two sorted linked list](#merge-two-sorted-linked-list)
- [Merge K Sorted Linked Lists](#merge-K-sorted-linked-lists)

## Single Linked list
```
First Node          2nd Node          3rd Node         4th Node
     |                 |                 |                 |
     |                 |                 |                 |
+----+------+     +----+------+     +----+------+     +----+------+
| 5  |   o------->| 3  |   o------->|  1 |   o------->| 4  | null |
+----+------+     +----+------+     +----+------+     +----+------+
```
[Implementation](single_linklist.py)

## Double Linked list
```
First Node          2nd Node          3rd Node         4th Node
     |                 |                 |                 |
     |                 |                 |                 |
             +--------------+    +--------------+     +--------------+
             |              |    |              |     |              |
+----+----+----+     +----+----+----+    +----+----+----+    +----+----+----+
|null| 5  |    |     |    | 3  |    |    |    |  1 |    |    |    | 4  |null|
+----+----+----+     +----+----+----+    +----+----+----+    +----+----+----+
       |               |     |              |    |              |
       +---------------+     +--------------+    +--------------+
```
[Implementation](doubly_linked_list.py)

## Delete node in a Linked list
Given a `key`, delete the first occurrence of this key in linked list.

To delete a node from linked list, we need to do following steps.
1) Find previous node of the node to be deleted.
2) Change the next of previous node.
3) Free memory for the node to be deleted.

[Implementation](delete_node_in_linklist_by_key.py)

## Middle of a linked list 
Given a singly linked list, Find the middle node of the linked list.\
For example:
Input: 7 -> 4 -> 6 -> 1 -> 3 -> 5 -> 2
Output: 1

Input: 7 -> 4 -> 6 -> 1 -> 3 -> 5 -> 2 -> 0
Output: 3

**Solution**\
We can use two pointers to traverse the linked list. Then move one pointer by 
one and other pointer by two. When the fast pointer reaches end slow pointer will 
reach middle of the linked list.

```python
p1
p2
7 -> 4 -> 6 -> 1 -> 3 -> 5 -> 2

  ->   ->
  -> p1   p2
7 -> 4 -> 6 -> 1 -> 3 -> 5 -> 2
            ->   ->
       -> p1        p2
7 -> 4 -> 6 -> 1 -> 3 -> 5 -> 2
                      ->   ->
            -> p1             p2
7 -> 4 -> 6 -> 1 -> 3 -> 5 -> 2
```
[Implementation](middle_of_linked_list.py)

## Find loop in a singly link list
Given a linked list of *n* nodes. The task is to check if the the linked list has a loop. Linked list can contain self loop.

Example:
```
Input: 5 -> 3 -> 7 -> 1
Output: False

Input: 5 -> 3 -> 7 -> 1
            ^         |
            |----------
Output: true
```

**Solution:**
We may use two pointers, on is faster another is slower to find if there is any loop in the linked list.
The slow pointer will move 1 step at a time while the faster will move 2 step at a time. If there is any loop in the
linked list then at some point the fast pointer will meet the slow pointer. If there is no loop then at some point next 
node reference of fast pointer will be *null*.

**Time Complexity:**
This approach is a single pass, and the solution is linear. So time complexity will be `O(n)`.

**Space Complexity:**
There is no additional space is required, hence space complexity is constant.
 
[Implementation](find_loop_in_linked_list.py)

## Remove n-th node from end of linked list
Given a linked list and an integer *N*, the task is to delete the *N-th* node from the end of the given linked list.

Example: 
```
Input: 2 -> 1 -> 3 -> 0 -> 7 -> 2   n = 3
Output: 2 -> 1 -> 3 -> 7 -> 2

Input: 2 -> 1 -> 3 -> 0 -> 7 -> 2   n = 6
Output: 1 -> 3 -> 0 -> 7 -> 2

Input: 2 -> 1 -> 3 -> 0 -> 7 -> 2   n = 1
Output: 2 -> 1 -> 3 -> 0 -> 7
```

**Solution**
For this problem we can use two pointers. The idea is to keep *n* as the difference between two pointers. 
One pointer will start from start, first node in the linked list and another pointer will start from *n-th* node of the linked list where *n* is the given number to delete. 
Then we traverse one node at a time and update both pointers. When the pointer ahead reaches at the end the other pointer will be at *n-th* position from the end, then we delete that node.

```
n = 3
linked list = 2 -> 1 -> 3 -> 0 -> 7 -> 2 
p1 = Node 2 = 2
p2 = Node 3 = 3 

2 -> 1 -> 3 -> 0 -> 7 -> 2
^         ^
p1        p2

2 -> 1 -> 3 -> 0 -> 7 -> 2
     ^         ^
     p1        p2    

2 -> 1 -> 3 -> 0 -> 7 -> 2
          ^         ^
          p1        p2        

2 -> 1 -> 3 -> 0 -> 7 -> 2
               ^         ^
               p1        p2        

p2 reached at the end, delete p1
2 -> 1 -> 3 -> 7 -> 2
```
**Time Complexity**
The approach is linear and single pass, so the time complexity is `O(n)`.

**Space Complexity**
Constant space complexity, `O(1)` as no additional space is required.

[Implementation](delete_nth_node_from_end.py)

## Remove loop from single link list if present
You are given a linked list of *N* nodes. The task is to remove the loop from the linked list, if present.

**Solution:**\
There are two part of this problem:
* Detect loop in the linked list, if exists
* Find start of the loop

We will use Floyd’s Cycle to identify loop in the linked list
* Initialize two pointers *ptr1* and *ptr2* with start node.
* Start traversing the Linked List using both the pointers, move pointer *ptr1* one node at a time and *ptr2* two nodes at a time.
* As *ptr2* is moving with double the speed, it will be ahead of *ptr1*. So check if *ptr2* encounters *NULL*. If it encounters *NULL*, then there is no loop in the Linked List and thus stop the execution. Else *ptr1* will enter the loop after some time following *ptr2*.
* When both the pointers are in the loop and continue to move with the same speed as before, they will eventually meet at some node. And that means there is a loop in the Linked List and thus stop the execution.

If there is a loop then *ptr1* and *ptr2* will point at the same node in the loop. Then reset *ptr2* to point the head of the linked list and keep *ptr1* at meeting node.
Then start moving both pointers at same speed until next pointer of both pointer *ptr1* and *ptr2* point to same node.
When *ptr1* and *ptr2* next of both the pointers will meet at the start node of the loop and *ptr2* will be pointing at the last node of the linked list.
Now assign NULL to the next of *ptr1* and stop the execution.

```python
5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
          ^                        ^
          --------------------------
p2        
p1                                   
5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
          ^                        ^
          --------------------------

                  
     p1   p2                                
5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
          ^                        ^
          --------------------------
          p1        p2                                          
5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
          ^                        ^
          --------------------------
               p1             p2                                          
5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
          ^                        ^
          --------------------------

          p2        p1                                                       
5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
          ^                        ^
          --------------------------
                    p2   p1                                                       
5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
          ^                        ^
          --------------------------
                              p2  
                              p1                                                  
5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
          ^                        ^
          --------------------------

Reset p2 -> head
                                
p2                            p1                                                  
5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
          ^                        ^
          --------------------------

     p2                            p1                                                  
5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
          ^                        ^
          --------------------------
Now, p1->next == p2->next          
p1->next = NULL
```
**Time Complexity**
Time complexity for detecting loop in linked list is linear, `O(n)` and for finding start of loop time complexity is `O(l)`, where l is the loop length, and `l <= n`. So ultimately time complexity is `O(n) + O(l) = O(n)`.

**Space Complexity**
Constant space complexity, `O(1)`.

## Merge two sorted linked list
**Problem**
Given two links lists with integer number and sorted. The task is the merge two linked list.

Example:
```python
List 1: 1 -> 2 -> 4 -> 5
List 2: 0 -> 1 -> 3 -> 6
Output: 0 -> 1 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
```

**Solution**:
The idea is the use create a third list from given linked lists. For this we compare items from both lists and add them to new list.

```python
MERGE_LINKED_LIST(L1, L2):
    L3 <- None
    if L1 is empty then:
        L3 = L2
    if L2 is empty then:
        L3 = L1
    if L1.data <= L2.data then:
        L3 = L1
        L3.next = MERGE_LINKED_LIST(L1.next, L2)
    else:
        L3 = L2
        L3.next = MERGE_LINKED_LIST(L1, L2.next)
    return L3
```

**Time Complexity**\
`O(m + n) = O(n)` 

**Space Complexity**\
Space complexity is constant, `O(1)`

[Implementation](merge_two_sorted_linked_list.py)

## Merge K Sorted Linked Lists
**Problem**:
Given a list of sorted linked list with numbers. Write a function to merge the linked lists and return a single linked list.

Example:
```
Input:
[
  2 -> 4 -> 6,
  0 -> 1 -> 3 -> 5,
  1 -> 9
]
Output: 0 -> 1-> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 9
```
This problem is similar to previous problem, `Merge two sorted linked list`.

**Solution 1**
We can simply create an array containing all the elements in the linked lists, and then sort the array. Then create a linked list from that sorted array.
Creating array will be `O(N)`, here *N* can be expressed as *N = k*n*, where *k* is the number of linked lists and *n* is the number of elements in each linked list. and sorting the best case will be `O(N log N)`.
Then creating the linked list will be `O(N)`.
So the time complexity will be `O(N log N) = O(n log n)`. And space complexity will be liner, `O(n)`.

[Implementation](merge_k_sorted_linked_list.py)

**Solution 2**\
We can use a Min-Heap to solve this problem. A Min-Heap is a complete binary tree in which the value in each internal node is smaller than or equal to the values in the children of that node.
First create a Min-Heap and add all the first node of each list. If the heap is not empty then:
* Remove the top element of the min-heap, and added that to the result linked list.
* If the next node of the top element is not empty then add the next node to the heap.

**Time Complexity**\
`O(n log k )`, *k* is total number of linked lists and *n* total number of nodes.

**Space Complexity**\
Space complexity is `O(k)`.
[Implementation - Java](../../java/src/com/ds/practice/MergeKSortedList/MergeKSortedListUsingMinHeap.java)

**Solution 3**\
We can use Divide and Conquer approach, recursively merge two linked list until all of them are merged.

```
lists = [l1, l2, l3, l4]
Iteration 1: merge lists[0]/l1 and lists[1]/l2, keep the result in lists[0]
Iteration 2: merge lists[2]/l3 and lists[3]/l4, keep the result in lists[2]
Iteration 3: merge lists[0] and lists[2], and keep the result lists[0] 
```
In this approach extra space is not required. Time complexity is *O(n log k)*.\
[Implementation - Java](../../java/src/com/ds/practice/MergeKSortedList/MergeKSortedList.java)

