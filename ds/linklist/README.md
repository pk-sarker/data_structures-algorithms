# Linked List
Linked list is a linear data structure when the memory allocation of the elements in the linked list is not contiguous. 
Each element or `node` in the linked list will have memory allocation based on availability. Each element will contain memory reference of the next node.

## Table of Contents
- [Single Linked list](#single-linked-list)
- [Double Linked list](#double-linked-list)
- [Delete node in a Linked list](#delete-node-in-a-linked-list)
- [Middle of a linked list ](#middle-of-a-linked-list)
- [Find loop in a singly link list](#find-loop-in-a-singly-link-list)
- [Remove n-th node from end of linked list](#remove-n-th-node-from-end-of-linked-list)

## Single Linked list
```
First Node          2nd Node          3rd Node         4th Node
     |                 |                 |                 |
     |                 |                 |                 |
+----+------+     +----+------+     +----+------+     +----+------+
| 5  |   o------->| 3  |   o------->|  1 |   o------->| 4  | null |
+----+------+     +----+------+     +----+------+     +----+------+
```
[Implementation](./single_linklist.py)

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
[Implementation](./doubly_linked_list.py)

## Delete node in a Linked list
Given a `key`, delete the first occurrence of this key in linked list.

To delete a node from linked list, we need to do following steps.
1) Find previous node of the node to be deleted.
2) Change the next of previous node.
3) Free memory for the node to be deleted.

[Implementation](./delete_node_in_linklist_by_key.py)

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
[Implementation](./middle_of_linked_list.py)

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
 
[Implementation](./find_loop_in_linked_list.py)

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
Constant space complexity as no additional space is required.
