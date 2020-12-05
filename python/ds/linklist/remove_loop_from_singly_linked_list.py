class Node:
    def __init__(self, value, next = None):
        self.data = value
        self.next = next

class LinkedList:
    def remove_loop(self, head):
        fast = slow = head
        meet = False
        while slow is not None or fast is not None:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                meet = True
                break

        if meet is True:
            slow = head
        else:
            return head

        while fast.next is not slow.next:
            fast = fast.next
            slow = slow.next
        fast.next = None
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

# 5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
#           ^                        ^
#           --------------------------
root = Node(5, Node(3, Node(9, Node(2, Node(1, Node(8, Node(0, Node(7))))))))
root.next.next.next.next.next.next.next.next = root.next.next

# 5 -> 3 -> 9 -> 2 -> 1 -> 8 -> 0 -> 7
#                                    ^
#                                    ^
# root.next.next.next.next.next.next.next.next = root.next.next.next.next.next.next.next
ll = LinkedList()
ll.print(ll.remove_loop(root))
