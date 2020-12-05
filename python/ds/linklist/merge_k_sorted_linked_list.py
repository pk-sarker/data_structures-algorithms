class Node:
    def __init__(self, value: int, next = None):
        self.data = value
        self.next = next


class LinkedList:
    def merge(self, lists) -> Node:
        ll3 = current = Node(-1)

        while any(list is not None for list in lists):
            current_min, i = min((list.data, i)
            for i, list in enumerate(lists) if list is not None)
            lists[i] = lists[i].next
            current.next = Node(current_min)
            current = current.next

        return ll3.next

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
ll2 = Node(2, Node(3, Node(3)))
ll3 = Node(0, Node(2, Node(3, Node(6, Node(8)))))

ll = LinkedList()
print("List 1:")
ll.print(ll1)
print("List 2:")
ll.print(ll2)
print("List 3:")
ll.print(ll3)
merged_list = ll.merge([ll1, ll2, ll3])
print("Merged: ")
ll.print(merged_list)
