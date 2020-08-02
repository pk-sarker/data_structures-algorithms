# Linked List
Linked list is a linear data structure when the memory allocation of the elements in the linked list is not contiguous. 
Each element or `node` in the linked list will have memory allocation based on availability. Each element will contain memory reference of the next node.

## Table of Contents
- [Single Linked list](#single-linked-list)
- [Double Linked list](#double-linked-list)
- [Delete node in a Linked list](#delete-node-in-a-linked-list)
- [Middle of a linked list ](#middle-of-a-linked-list)
- [Find loop in a singly link list](#find-loop-in-a-singly-link-list)

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