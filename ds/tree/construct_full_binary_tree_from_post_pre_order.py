class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.data = val
        self.left = left
        self.right = right

class Solution:
    def construct_tree(self, pre_order: [], post_order: []) -> TreeNode:
        if not pre_order:
            return None
        root_node = TreeNode(pre_order[0])
        if len(pre_order) == 1:
            return root_node

        # Nodes in left branch
        L = post_order.index(pre_order[1]) + 1

        root_node.left = self.construct_tree(pre_order[1: L + 1], post_order[:L])
        root_node.right = self.construct_tree(pre_order[L+1:], post_order[L:-1])

        return root_node

root = Solution().construct_tree([1, 2, 4, 5, 3, 6, 7], [4, 5, 2, 6, 7, 3, 1])

print("Root\tLeft\tRight")
print("{}\t\t{}\t\t{} ".format(root.data, root.left.data, root.right.data))
print("{}\t\t{}\t\t{} ".format(root.left.data, root.left.left.data, root.left.right.data))
print("{}\t\t{}\t{} ".format(root.left.left.data, root.left.left.left, root.left.left.right))
print("{}\t\t{}\t{} ".format(root.left.right.data, root.left.right.left, root.left.right.right))
print("{}\t\t{}\t\t{} ".format(root.right.data, root.right.left.data, root.right.right.data))
print("{}\t\t{}\t{} ".format(root.right.left.data, root.right.left.left, root.right.left.right))
print("{}\t\t{}\t{} ".format(root.right.right.data, root.right.right.left, root.right.right.right))
