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


