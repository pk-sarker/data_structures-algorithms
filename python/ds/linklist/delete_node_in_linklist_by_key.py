# Given a `key`, delete the first occurrence of this key in linked list. `key` represents the value of the node.
#
# Example:
# Linked list: 4 -> 9 -> 0 -> 7 -> 3
# Delete Node: 0
# Output: 4 -> 9 -> 7 -> 3
# Delete Node: 4
# Output: 9 -> 7 -> 3
# Delete Node: 3
# Output: 9 -> 7


class Node:
    def __init__(self, value, next = None):
        self.data = value
        self.next = next

class LinkedList:
    def delete(self, head, node_value):
        node = head
        if node is None:
            print('Linked list is empty')
        prev = None
        while node is not None:
            if node.data == node_value:
                if prev == None: # delete Start node
                    head = node.next
                elif node.next is None:
                    prev.next = None
                else:
                    temp = node.next
                    prev.next = temp
                break
            prev = node
            node = node.next
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


node = Node(4, Node(9, Node(0, Node(7, Node(3)))))
ll = LinkedList()
print("Linked List:")
ll.print(node)
print("Delete node 0")
node = ll.delete(node, 0)
ll.print(node)
print("Delete node 4 (First node)")
node = ll.delete(node, 4)
ll.print(node)
print("Delete node 3 (Last node)")
node = ll.delete(node, 3)
ll.print(node)
