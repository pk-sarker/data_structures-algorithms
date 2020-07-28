class Node:
    def __init__(self, value, next = None):
        self.data = value
        self.next = next

class LinkedList:
    def find_middle(self, head):
        if head is None:
            return None
        p1 = head
        p2 = head
        while p2.next is not None:
            p1 = p1.next
            if p2.next.next is not None:
                p2 = p2.next.next
            else:
                p2 = p2.next
        return p1

    def print(self, head):
        node = head
        ll = ""
        while node is not None:
            ll += str(node.data)
            if node.next is not None:
                ll += " -> "
            node = node.next
        print(ll)
# 7 -> 4 -> 6 -> 1 -> 3 -> 5 -> 2
node = Node(7, Node(4, Node(6, Node(1, Node(3, Node(5, Node(2)))))))
ll = LinkedList()
print("Linked List:")
ll.print(node)
middle = ll.find_middle(node)
print("Middle: {}".format(middle.data))

node2 = Node(7, Node(4, Node(6, Node(1, Node(3, Node(5, Node(2, Node(0))))))))
print("Linked List:")
ll.print(node2)
middle = ll.find_middle(node2)
print("Middle: {}".format(middle.data))