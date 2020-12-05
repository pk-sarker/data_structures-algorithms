# Queue

## Pseudocode

`Enqueue`: Adding an element to the rear of the queue.
```
ENQUEUE(Q,x)
1 Q[Q.tail] = x
2 if Q.tail == Q.length
3   Q.tail = 1;
4 else Q.tail] = Q.Tail + 1
```


`Dequeue`: Operation to remove an element from the front of the queue.
```
DEQUEUE(Q)
1 x = Q.head
2 if Q.head == Q.length
3   Q.head = 1
4 else Q.head = Q.head + 1
5 return x
```

# Priority Queue
Priority Queue is a data structure similar to `Queue` or `Stack` in which each element is associated with 
a property `Priority`. In priority queue an element with higher priority is served before an element with lower 
priority. If two elements with same priority, they served according to the order in which they enqueued.

A priority queue must have the following operations:
* *is_empty*: check if the queue has no elements, returns boolean result
* *insert_with_priority*: Insert an element to the queue with an associated priority.
* *pull_element_with_highest_priority*: Remove an element with highest priority from the queue and return it.
* *peek*: Return an element with highest priority from the queue without modifying the queue.

A priority queue can be implemented using common data structures like: Linkedlist, Heap, array and binary tree.

### Implementations using Linked list:
Highest priority elements will be always at the head of the linked list.
[Implementation](priority_queue.py)


