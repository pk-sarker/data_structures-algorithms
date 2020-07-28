# Linked List
Linked list is a linear data structure when the memory allocation of the elements in the linked list is not contiguous. 
Each element or `node` in the linked list will have memory allocation based on availability. Each element will contain memory reference of the next node.

## Single Linked list
```
First Node          2nd Node          3rd Node         4th Node
     |                 |                 |                 |
     |                 |                 |                 |
+----+------+     +----+------+     +----+------+     +----+------+
| 5  |   o------->| 3  |   o------->|  1 |   o------->| 4  | null |
+----+------+     +----+------+     +----+------+     +----+------+
```



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
## Delete node in a Linked list
Given a `key`, delete the first occurrence of this key in linked list.

To delete a node from linked list, we need to do following steps.
1) Find previous node of the node to be deleted.
2) Change the next of previous node.
3) Free memory for the node to be deleted.
