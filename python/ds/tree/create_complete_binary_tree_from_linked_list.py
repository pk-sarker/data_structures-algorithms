# Problem: Construct a complete binary tree from a linked list
#
#                   1
#                /     \
#               2       3
#              / \     / \
#             4   5   6   7
#            / \  /
#           8  9 10
#
# Input: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
# Output:
# Print Link List
# 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
#
# In Order:
# 8 4 9 2 10 5 1 6 3 7
#
#

from queue import Queue


class ListNode:
    def __init__(self, value):
        self.data = value
        self.next = None


class Node:
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None


def create_linked_list(elements):
    tail = None
    head = None
    for x in elements:
        new_node = ListNode(x)
        if head is None:
            head = new_node
        if tail is None:
            tail = new_node
        else:
            tail.next = new_node
            tail = new_node

    return {'head': head, 'tail': tail}


def create_complete_binary_tree(head):

    q = Queue()
    if head is None:
        root = None
        return
    root = Node(head.data)
    q.put(root)
    pointer = head.next

    while pointer:
        parent_node = q.get()

        left_node = None
        right_node = None

        left_node = Node(pointer.data)
        q.put(left_node)
        pointer = pointer.next

        if pointer:
            right_node = Node(pointer.data)
            q.put(right_node)
            pointer = pointer.next

        parent_node.left = left_node
        parent_node.right = right_node

    traverse_in_order(root)


# Traverse Left child first, then root node and then right child
def traverse_in_order(root_node):
    if root_node is not None:
        traverse_in_order(root_node.left)
        print(root_node.data, end=" ")
        traverse_in_order(root_node.right)


def print_list(head):
    print("Print Link List")
    temp = head
    list = ""
    while temp is not None:
        # print(temp.data)
        list += str(temp.data)
        if temp.next is not None:
            list += " -> "
        temp = temp.next
    print(list)


if __name__ == "__main__":
    llist = create_linked_list([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    print_list(llist['head'])
    print("head: ", llist['head'].data)
    print("tail: ", llist['tail'].data)
    create_complete_binary_tree(llist['head'])
