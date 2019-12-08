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

    def swap1(self, node_a, node_b):
        print("\nSwap node with value {} with node with value {}".format(node_a, node_b))
        pointer = self.__head
        pointer_a = None
        pointer_b = None

        while pointer is not None:
            if pointer.data == node_a:
                pointer_a = pointer
            if pointer.data == node_b:
                pointer_b = pointer
            if pointer_a is not None and pointer_b is not None:
                print("both: {} {}".format(pointer_a.data, pointer_b.data))

                temp_a = pointer_a
                temp_b = pointer_b

                # a.prevNode.next -> a 1
                # a.prev -> b.prevNode 3
                # a.next -> b.nextNone 2
                # a.nextNode.prev -> b 4

                # b.prevNode.next -> a 5
                # b.prev -> a.prev 6
                # b.next -> a.next 7
                # b.nextNode.prev -> a

                # pointer_a.previous.next = pointer_b # 1 -
                #
                # pointer_a.next = pointer_b.next # 2 -
                #
                # pointer_a.previous = pointer_b.previous # 3 -
                #
                # temp_a.next.previous = pointer_b  # 4
                #
                # self.print_list()
                # print(">> ", temp_b.next.data)
                # print(">> ", temp_b.previous.data)

                pointer_b.previous.next = pointer_a
                # temp_b.next.previous = temp_a # 5
                # #
                pointer_b.next = pointer_a.next
                # temp_b.previous = temp_a.previous # 6
                # #
                pointer_b.previous = pointer_a.previous

                temp_b.next.previous = pointer_a
                # temp_b.previous.next = temp_a.next # 7

                # temp_a.next.previous = pointer_b
                # pointer_b.previous = temp_a.next
                # temp_b.previous = temp_a.previous # 8
                # self.print_list()

                self.print_list()
                print(">> ", temp_b.next.data)
                print(">> ", temp_b.previous.data)
                break

            pointer = pointer.next

    def swap(self, node_a, node_b):
        print("\nSwap node with value {} with node with value {}".format(node_a, node_b))
        pointer = self.__head
        pointer_a = None
        pointer_b = None

        while pointer is not None:
            if pointer.data == node_a:
                pointer_a = pointer
            if pointer.data == node_b:
                pointer_b = pointer
            if pointer_a is not None and pointer_b is not None:
                print("both: {} {}".format(pointer_a.data, pointer_b.data))

                node_a_next = pointer_a.next
                node_a_prev = pointer_a.previous

                # If node a is the last node/tail of the list,
                # then updated the tail reference to node b
                # because after swapping node b is will
                # in position of node a
                if pointer_a.next is not None:
                    pointer_a.next.previous = pointer_b
                else:
                    self.__tail = pointer_b

                # If node a is the first node/head of the list,
                # then updated the head reference to node b
                # because after swapping node b is will
                # in position of node a
                if pointer_a.previous is not None:
                    pointer_a.previous.next = pointer_b
                else:
                    self.__head = pointer_b

                pointer_a.next = pointer_b.next  # 1
                pointer_a.previous = pointer_b.previous

                # If a node is head node then no need to set next
                # node reference of current node's previous node
                if pointer_b.next is not None:
                    pointer_b.next.previous = pointer_a
                else:
                    self.__tail = pointer_a

                if pointer_b.previous is not None:
                    pointer_b.previous.next = pointer_a
                else:
                    self.__head = pointer_a

                pointer_b.next = node_a_next
                pointer_b.previous = node_a_prev
                break

            pointer = pointer.next


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
    list.swap(-3, 5)
    list.print_list()
    list.swap(4, -3)
    list.print_list()
