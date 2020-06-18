# Problem:
# Given a binary tree, delete a node from it by making sure that tree
# shrinks from the bottom.
#
#             10
#           /    \
#         11       9
#        /  \     /  \
#       7    6   15   8
#      /
#     12
#
#
# Input:
# In Order:
# 12 7 11 6 10 15 9 8
#
# Delete 7
# In Order:
# 12 8 11 6 10 15 9
#             10
#           /    \
#         11       9
#        /  \     /
#       8    6   15
#      /
#     12
#
# Delete 15
# In Order:
# 12 8 11 6 10 15 9
#             10
#           /    \
#         11       9
#        /        /
#       8        6
#      /
#     12


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


child = []
dict = {}


def find_and_delete_node(root, key):
    if root is None:
        return None

    if root.left is not None and root.left.data == key:
        print("Found " + str(key))
        child_node = child.pop()
        print("Pop: " + str(child_node.data))

        if child_node is not None and ( child_node.data == root.left.data or child_node.data == root.right.data):
            child_node = child.pop()

        if child_node is not None:
            if dict[child_node.data] is not None and dict[child_node.data].right is not None and dict[
                child_node.data].right.data == child_node.data:
                dict[child_node.data].right = None
            else:
                dict[child_node.data].left = None

            if root.left is not None:
                child_node.left = root.left.left
                child_node.right = root.left.right
                root.left.left = None
                root.left.right = None
            root.left = child_node
        else:
            print("Tree is Empty")
    elif root.right is not None and root.right.data == key:
        child_node = child.pop()
        if dict[child_node.data] is not None and dict[child_node.data].right is not None and dict[
            child_node.data].right.data == child_node.data:
            dict[child_node.data].right = None
        else:
            dict[child_node.data].left = None

        if child_node is not None:
            if root.right is not None:
                child_node.left = root.right.left
                child_node.right = root.right.right
                root.right.left = None
                root.right.right = None
            root.right = child_node
        else:
            print("Tree is Empty")
    else:
        find_and_delete_node(root.left, key)
        find_and_delete_node(root.right, key)


def get_right_most_node(root):
    if root.right is not None:
        get_right_most_node(root.right)


# Traverse Left child first, then root node and then right child
def traverse_in_order(root_node):
    if root_node is not None:
        if root_node.left is not None and root_node.left.left is None and root_node.left.right is None:
            child.append(root_node.left)
            dict[root_node.left.data] = root_node
        traverse_in_order(root_node.left)
        print(root_node.data, end=" ")
        if root_node.right is not None and root_node.right.left is None and root_node.right.right is None:
            child.append(root_node.right)
            dict[root_node.right.data] = root_node
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

    # print(len(child))
    print("\nDelete node 7")
    find_and_delete_node(root, 7)

    print("\nIn Order:")
    traverse_in_order(root)
    print("\n\n")

    print("\nDelete node 15")
    find_and_delete_node(root, 15)
    print("\nIn Order:")
    traverse_in_order(root)
