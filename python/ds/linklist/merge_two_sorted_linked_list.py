# List 1: 1 -> 2 -> 4 -> 5
# List 2: 0 -> 1 -> 3 -> 6 -> 8
# Output: 0 -> 1 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
#
class Node:
    def __init__(self, value: int, next = None):
        self.data = value
        self.next = next

class LinkedList:
    def merge(self, l1: Node, l2: Node) -> Node:
        ll3 = None
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        if l1.data <= l2.data:
            ll3 = l1
            ll3.next = self.merge(l1.next, l2)
        else:
            ll3 = l2
            ll3.next = self.merge(l1, l2.next)
        return ll3

    def print(self, head):
        node = head
        ll = ""
        while node is not None:
            ll += str(node.data)
            if node.next is not None:
                ll += " -> "
            node = node.next
        print(ll)

ll1 = Node(1, Node(2, Node(4, Node(5))))
ll2 = Node(0, Node(1, Node(3, Node(6, Node(8)))))

# ll1 = Node(1)
# ll2 = Node(0)

ll = LinkedList()
print("List 1:")
ll.print(ll1)
print("List 2:")
ll.print(ll2)
merged_list = ll.merge(ll1, ll2)
print("Merged: ")
ll.print(merged_list)
