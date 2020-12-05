class Node:
    def __init__(self, value):
        self.data = value
        self.next = None


class SingleLinkList:

    def __init__(self):
        self.head = None
        self.tail = None

    def add_node(self, value):
        print("Adding Node with value ", value)
        node = Node(value)
        if self.head is None:
            self.head = node
            self.tail = self.head
        else:
            self.tail.next = node
            self.tail = self.tail.next

    def remove(self, value):
        print("Remove node with value ", value)
        pointer = self.head
        previous = None
        while pointer is not None:
            if pointer.data == value:
                if pointer.next is not None:
                    previous.next = pointer.next
                    pointer.next = None;
                else:
                    previous.next = None
            previous = pointer
            pointer = pointer.next

    def print(self):
        print("Print Link List")
        temp = self.head
        list = ""
        while temp is not None:
            # print(temp.data)
            list += str(temp.data)
            if temp.next is not None:
                list += " -> "
            temp = temp.next
        print(list)

# Code execution starts here


if __name__ == "__main__":
    slist = SingleLinkList()
    slist.add_node(7)
    slist.add_node(1)
    slist.add_node(5)
    slist.print()
    slist.add_node(6)
    slist.add_node(-4)

    slist.print()

    slist.remove(1)
    slist.print()





