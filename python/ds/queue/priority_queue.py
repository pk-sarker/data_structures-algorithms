# Implement priority queue that has the following functionalities:
#   is_empty: check if the queue has no elements, returns boolean result
#   insert_with_priority: Insert an element to the queue with an associated priority.
#   pull_element_with_highest_priority: Remove an element with highest priority from the queue and return it.
#   peek: Return an element with highest priority from the queue without modifying the queue.

class Node:
  def __init__(self, value, priority=None, next=None):
    self.value = value
    self.priority = priority
    self.next = next


class PriorityQueue:
  llist_size = 0
  def __init__(self):
    self.head = Node('head', 1000)
    self.MaxPriority = None

  def is_empty(self):
    return None

  def insert_with_priority(self, value, priority):
    node = Node(value, priority)
    if self.head.next is None:
      self.head.next = Node(value, priority)
    else:
      current = self.head.next
      while current != None:
        if priority > current.priority:

      current = current.next

    return None

  def pull_element_with_highest_priority(self):
    return None

  def peek(self):
    return None


if __name__ == "__main__":
  pq = PriorityQueue()
  pq.insert_with_priority(3, 1)






