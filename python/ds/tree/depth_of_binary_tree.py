
class TreeNode:
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right

def find_depth(root):
    if root is None:
        return 0
    return 1 + max(find_depth(root.left), find_depth(root.right))

def find_depth2(root, depth = 0):
    if root is None:
        return depth + 0
    if root.left is None and root.right is None:
        return depth + 1
    if root.left is None:
        return find_depth2(root.right, depth+1)
    if root.right is None:
        return find_depth2(root.left, depth+1)

    return max(find_depth2(root.left, depth+1), find_depth2(root.right, depth+1))

def find_depth_iterative(root):
    stack = [(1, root)]

    max_depth = 0
    while len(stack)>0:
        current_depth, current_node = stack.pop()
        if current_node:
            max_depth = max(max_depth, current_depth)
            stack.append((current_depth + 1, current_node.left))
            stack.append((current_depth + 1, current_node.right))

    return max_depth


#          a
#        /   \
#       b     c
#        \   / \
#         e f   g
#                \
#                 h
root = TreeNode('a', TreeNode('b', None, TreeNode('e')), TreeNode('c', TreeNode('f'), TreeNode('g', None, TreeNode('h'))))
print("Level: {}".format(find_depth(root)))
print("Level: {}".format(find_depth2(root, 0)))
#          a
#        /   \
#       b     c
#        \   /
#         d e
root2 = TreeNode('a', TreeNode('b', None, TreeNode('d')), TreeNode('c', TreeNode('e'), None))
print("Level: {}".format(find_depth(root2)))
print("Level: {}".format(find_depth2(root2, 0)))

print("Iterative Level: {}".format(find_depth_iterative(root2)))

