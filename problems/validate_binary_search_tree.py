#
# Given a binary tree, check if the tree is a valid binary search tree(BST).
#
# The Binary Search Tree has the following properties:
# * Each node is represented by a Key, numeric type
# * Each node may be at max two child, left and right
# * The left subtree of a node(A) contains the nodes which are less than parent node(A)
# * The right subtree of a node(A) contains the nodes which are greater than parent node(A)
# * Both left and right subtrees must be binary search tree
#
# Example:
# a)          8
#            / \
#           6  10
#          / \
#         1   5
#
# b)           8
#             / \
#            6   10
#                / \
#               7  12
#
# c)           8
#             / \
#            6   10
#           / \
#          4   9
#
# d)          8
#           /    \
#          6     10
#         / \    / \
#        3   7  9  12
#
# e)           8
#             / \
#            6   10
#           / \
#          4   7


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class Validator:
    def isValidBinarySearchTree(self, root_node: Node) -> bool:
        def helper(node, lower_bound, upper_bound):
            if not node:
                return True

            if node.data <= lower_bound or node.data >= upper_bound:
                return False

            if not helper(node.right, node.data, upper_bound):
                return False
            if not helper(node.left, lower_bound, node.data):
                return False
            return True

        return helper(root_node, float('-inf'), float('inf'))


if __name__ == "__main__":
    tree_a_root = None
    tree_a_root = Node(8)
    tree_a_root.left = Node(6)
    tree_a_root.right = Node(10)
    tree_a_root.left.left = Node(1)
    tree_a_root.left.right = Node(5)
    print("a)          8")
    print("           / \\")
    print("          6  10")
    print("         / \\")
    print("        1   5")



    isValidBST = Validator().isValidBinarySearchTree(tree_a_root)
    if isValidBST is True:
        print("Tree a): This is a valid Binary Search Tree")
    else:
        print("Tree a): This is not a valid Binary Search Tree")

    print("b)           8")
    print("            / \\")
    print("           6  10")
    print("              / \\")
    print("             7  12")
    tree_b_root = None
    tree_b_root = Node(8)
    tree_b_root.left = Node(6)
    tree_b_root.right = Node(10)
    tree_b_root.right.left = Node(7)
    tree_b_root.right.right = Node(12)

    isValidBST = Validator().isValidBinarySearchTree(tree_b_root)
    if isValidBST is True:
        print("Tree b): This is a valid Binary Search Tree")
    else:
        print("Tree b): This is not a valid Binary Search Tree")

    print("c)           8")
    print("            / \\")
    print("           6  10")
    print("          / \\")
    print("         4   9")
    tree_c_root = None
    tree_c_root = Node(8)
    tree_c_root.left = Node(6)
    tree_c_root.right = Node(10)
    tree_c_root.left.left = Node(4)
    tree_c_root.left.right = Node(9)

    isValidBST = Validator().isValidBinarySearchTree(tree_c_root)
    if isValidBST is True:
        print("Tree c): This is a valid Binary Search Tree")
    else:
        print("Tree c): This is not a valid Binary Search Tree")

    print("d)          8")
    print("           / \\")
    print("         6    10")
    print("        / \\   / \\")
    print("       3   7 9  12")
    tree_d_root = None
    tree_d_root = Node(8)
    tree_d_root.left = Node(6)
    tree_d_root.right = Node(10)
    tree_d_root.left.left = Node(3)
    tree_d_root.left.right = Node(7)
    tree_d_root.right.left = Node(9)
    tree_d_root.right.right = Node(12)

    isValidBST = Validator().isValidBinarySearchTree(tree_d_root)
    if isValidBST is True:
        print("Tree d): This is a valid Binary Search Tree")
    else:
        print("Tree d): This is not a valid Binary Search Tree")

    print("e)           8")
    print("            / \\")
    print("           6   10")
    print("          / \\")
    print("         4   7")
    tree_e_root = None
    tree_e_root = Node(8)
    tree_e_root.left = Node(6)
    tree_e_root.right = Node(10)
    tree_e_root.left.left = Node(4)
    tree_e_root.left.right = Node(7)

    isValidBST = Validator().isValidBinarySearchTree(tree_e_root)
    if isValidBST is True:
        print("Tree e): This is a valid Binary Search Tree")
    else:
        print("Tree e): This is not a valid Binary Search Tree")
