# Input: 5 -> 3 -> 7 -> 1
# Output: False
#
# Input: 5 -> 3 -> 7 -> 1
#             |         |
#             |----------
# Output: False

class Node:
    def __init__(self, value, next= None):
        self.data = value
        self.next = next

class LinkedList:
    def find_loop(self, head):
        slow = head
        fast = head
        proceed = True
        while proceed:
            if fast is None or fast.next is None:
                return False
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True


root = Node(5, Node(3, Node(7, Node(1))))

print(LinkedList().find_loop(root))

# 5 -> 3 -> 7 -> 1
#      ^         |
#      |----------
node3 = None
node1 = Node(1, node3) # Placeholder for node 3
node7 = Node(7, node1)
node3 = Node(3, node7) # creating node 3
node5 = Node(5, node3)
node1.next = node3  # update node 3 placeholder
print(LinkedList().find_loop(node5))

# 5 -> 3 -> 7 -> 1
# ^              |
# |---------------

node5 = None
node1 = Node(1, node5) # Placeholder for node 3
node7 = Node(7, node1)
node3 = Node(3, node7) # creating node 3
node5 = Node(5, node3)
node1.next = node5  # update node 3 placeholder
print(LinkedList().find_loop(node5))
