# Problem:
# Given a binary tree and a key, insert the key into the binary tree at
# first position available in level order.
#
# Input:
# In Order:
# 12 7 11 6 10 15 9 8
#
# Output:
# 12 7 13 11 6 10 15 9 8
#
from queue import Queue


class Node:
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None


def insert_node(key, root):
    q = Queue()
    q.put(root)
    while not q.empty():
        node = q.get()

        if node is not None:
            if node.left is None:
                node.left = Node(key)
                break;
            else:
                q.put(node.left)

            if node.right is None:
                node.right = Node(key)
                break;
            else:
                q.put(node.right)

    traverse_in_order(root)


# Traverse Left child first, then root node and then right child
def traverse_in_order(root_node):
    if root_node is not None:
        traverse_in_order(root_node.left)
        print(root_node.data, end=" ")
        traverse_in_order(root_node.right)


if __name__ == "__main__":
    root = None
    root = Node(10)
    root.left = Node(11)
    root.right = Node(9)
    root.left.left = Node(7)
    root.left.right = Node(6)
    root.right.left = Node(15)
    root.right.right = Node(8)
    root.left.left.left = Node(12)
    print("\nIn Order:")
    traverse_in_order(root)
    print("\n\n")

    insert_node(13, root)

