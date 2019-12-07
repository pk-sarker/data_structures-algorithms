class Node:
    def __init__(self, value=None, next=None, previous=None):
        self.data = value
        self.next = next
        self.previous = previous


class DoublyLinkedList:

    def __init__(self):
        self.__head = None
        self.__tail = self.__head

    def print_list(self):
        if self.__head is None:
            print("Linked list is empty")
        else:
            pointer = self.__head
            list = ""
            while pointer is not None:
                list += str(pointer.data)
                if pointer.next is not None:
                    list += " -> "
                pointer = pointer.next
            print("List: ", list)

    def add_node(self, value=None):
        new_node = Node(value)
        if value is not None:
            print("Adding Node with value ", value)
            if self.__tail is not None:
                new_node.previous = self.__tail
                self.__tail.next = new_node
                self.__tail = new_node
            else:
                self.__head = new_node
                self.__tail = new_node
        else:
            print("Can't add null value")

    def remove(self, value):
        print("\n")
        self.print_list()
        print("Remove node with value ", value)
        pointer = self.__head
        while pointer is not None:
            if pointer.data == value:
                # If first node
                if pointer.previous is None:
                    self.__head = pointer.next
                    pointer.next = None
                    pointer.data = None
                # If last node
                elif pointer.next is None:
                    pointer.previous.next = None
                    pointer.previous = None
                    pointer.data = None
                # If intermediate none
                else:
                    pointer.previous.next = pointer.next
                    pointer.next.previous = pointer.previous
                    pointer.previous = None
                    pointer.next = None
                break

            pointer = pointer.next



    def search(self, value):
        print("\nSearch node with value ", value)
        pointer = self.__head
        while pointer is not None:
            if pointer.data == value:
                return True
            pointer = pointer.next
        return False


if __name__ == "__main__":
    list = DoublyLinkedList()
    list.add_node(5)
    list.print_list()
    list.add_node(9)
    list.print_list()
    list.add_node(-3)
    list.print_list()
    list.add_node(1)
    list.print_list()
    list.add_node(8)
    list.print_list()
    list.add_node(4)
    list.print_list()
    list.remove(5)
    list.print_list()
    list.remove(4)
    list.print_list()
    list.remove(1)
    list.print_list()
