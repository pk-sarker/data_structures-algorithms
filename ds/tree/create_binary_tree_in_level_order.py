# Problem: Construct a complete binary tree in level order
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
# In Order:
# 8 4 9 2 10 5 1 6 3 7
#
# Pre Order:
# 1 2 4 8 9 5 10 3 6 7
#
# Post Order:
# 8 9 4 10 5 2 6 7 3 1
#


class Node:
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None


def add_node_in_level_order(elements: object, root_node, root_node_index, total_node):

    if elements is not None and root_node is None and root_node_index is not None and total_node is not None:
        # Level is less than total number of nodes
        if root_node_index < total_node:
            new_node = Node(elements[root_node_index])
            root_node = new_node

            root_node.left = add_node_in_level_order(elements, root_node.left, 2 * root_node_index + 1, total_node)

            root_node.right = add_node_in_level_order(elements, root_node.right, 2 * root_node_index + 2, total_node)

    return root_node


# Traverse Left child first, then root node and then right child
def traverse_in_order(root_node):
    if root_node is not None:
        traverse_in_order(root_node.left)
        print(root_node.data, end=" ")
        traverse_in_order(root_node.right)


# Traverse root node first, then Left child and then right child
def traverse_pre_order(root_node):
    if root_node is not None:
        print(root_node.data, end=" ")
        traverse_pre_order(root_node.left)
        traverse_pre_order(root_node.right)


# Traverse first Left child, then right child and then root node
def traverse_post_order(root_node):
    if root_node is not None:
        traverse_post_order(root_node.left)
        traverse_post_order(root_node.right)
        print(root_node.data, end=" ")


if __name__ == '__main__':
    items = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    n = len(items)
    root = None
    root = add_node_in_level_order(items, root, 0, n)
    print("\nIn Order:")
    traverse_in_order(root)
    print("\n\nPre Order:")
    traverse_pre_order(root)
    print("\n\nPost Order:")
    traverse_post_order(root)













