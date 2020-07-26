class Node:
    def __init__(self, value, next=None):
        self.data = value
        self.next = next


class LinkList:
    def reverse(self, head):
        current = head
        previous = None

        while current is not None:
            temp = current.next
            current.next = previous
            previous = current
            current = temp
        return previous

    def print_link_list(self, head):
        temp = head
        list = ""
        while temp is not None:
            list += str(temp.data)
            if temp.next is not None:
                list += " -> "
            temp = temp.next
        print(list)


head = Node(5, Node(8, Node(4, Node(9, Node(0, Node(3))))))

ll = LinkList()
ll.print_link_list(head)
reverse_list = ll.reverse(head)
ll.print_link_list(reverse_list)