# Input: 2 -> 1 -> 3 -> 0 -> 7 -> 2
# Output:
#   Remove 3 node from end
#   2 -> 1 -> 3 -> 7 -> 2
#   Remove 0 node from end
#   2 -> 1 -> 3 -> 7
#   Remove 4 node from end
#   1 -> 3 -> 7
class Node:
    def __init__(self, value, next = None):
        self.data = value
        self.next = next

class LinkedList:
    def move_pointer_to_nth_position(self, pointer, n):
        i = 1
        while i < n:
            pointer = pointer.next
            i += 1
        return pointer

    def remove_nth_node_from_end(self, head, n):
        print("Remove {} node from end".format(n))
        p1 = head
        p2 = self.move_pointer_to_nth_position(head, n)
        prev = None
        while p2.next is not None:
            prev = p1
            p1 = p1.next
            p2 = p2.next

        if prev is None:
            head = p1.next
        else:
            prev.next = p1.next
        return head

    def print(self, head):
        node = head
        ll = ""
        while node is not None:
            ll += str(node.data)
            if node.next is not None:
                ll += " -> "
            node = node.next
        print(ll)

# 2 -> 1 -> 3 -> 0 -> 7 -> 2
root = Node(2, Node(1, Node(3, Node(0, Node(7, Node(2))))))
ll = LinkedList()
ll.print(root)
ll.print(ll.remove_nth_node_from_end(root, 3))

ll.print(ll.remove_nth_node_from_end(root, 0))

ll.print(ll.remove_nth_node_from_end(root, 4))