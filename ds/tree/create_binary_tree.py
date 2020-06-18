# Problem:
# Given an array of elements, sorted in ascending order, task is to construct a complete binary tree from
# this array using level order approach. That is, elements from left in the array
# will be filled in the tree level wise starting from level 0.
#
# Examples:
# Input  :  arr[] = {1, 2, 3, 4, 5, 6}
# Output : Root of the following tree
#                   1
#                  / \
#                 2   3
#                / \ /
#               4  5 6
# In-order traversal: 4 2 5 1 6 3

# Input: arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
# Output : Root of the following tree
#                   1
#                /     \
#              2         3
#            /   \      /  \
#           4     5    6    7
#          / \   / \  /
#         8  9 10  11 12
#
# In-order traversal: 8 4 9 2 10 5 11 1 12 6 3 7

class Node:
    def __init__(self, data):
        self.data = data
        self.left = self.right = None


def insert_node_in_level_order(arr, root_node, i, n):
    # Base case for recursion
    # any index either of left child or right child
    # has to be less than the number of elements in the array
    # If i > n that means there are not enough elements remaining
    # in the array to continue to next level
    if i < n:
        root_node = Node(arr[i])

        # Add left child
        # Left child of current level i will be
        # 2^i + 1 th element because it will require 2^i elements at level i

        root_node.left = insert_node_in_level_order(arr, root_node.left,  2 * i + 1, n)

        # Add right child
        # Right child of current level i will be
        # ((2^i + 1)+1) = 2^i + 2 th element because it will require
        # 2^i elements at level i and one element for left child
        root_node.right = insert_node_in_level_order(arr, root_node.right,  2 * i + 2, n)
    return root_node


# Traverse Left child first, then root node and then right child
def traverse_in_order(root_node):
    if root_node is not None:
        traverse_in_order(root_node.left)
        print(root_node.data, end=", ")
        traverse_in_order(root_node.right)

# Traverse root node first, then Left child and then right child
def traverse_pre_order(root_node):
    if root_node is not None:
        print(root_node.data, end=", ")
        traverse_pre_order(root_node.left)
        traverse_pre_order(root_node.right)

if __name__ == "__main__":

    arr = [1, 2, 3, 4, 5, 6]
    root = None
    root = insert_node_in_level_order(arr, root, 0, len(arr))
    traverse_in_order(root)

    root = None
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    root = insert_node_in_level_order(arr, root, 0, len(arr))
    print("\nPre-order: ")
    traverse_pre_order(root)

    print("\nIn-order: ")
    traverse_in_order(root)




