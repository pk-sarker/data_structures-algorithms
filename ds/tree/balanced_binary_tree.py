class TreeNode:
    def __init__(self, data, left = None, right = None):
        self.data = data
        self.left = left
        self.right = right


class Solution:
    def is_balanced(self, root):
        return self._is_balanced_and_height(root)[0]

    def _is_balanced_and_height(self, root):
        if not root:
            return (True, 0)

        left_balanced, l_height = self._is_balanced_and_height(root.left)
        right_balanced, r_height = self._is_balanced_and_height(root.right)

        return left_balanced and right_balanced and abs(l_height - r_height) <= 1, max(l_height, r_height) + 1


print('        a')
print('       / \\')
print('      b   c')
print('     /')
print('    d')

root = TreeNode('a', TreeNode('b', TreeNode('d')), TreeNode('c'))
print(Solution().is_balanced(root))

print('        a')
print('       /')
print('      b')
print('     / \\')
print('    c  d')

root2 = TreeNode('a', TreeNode('b', TreeNode('c'), TreeNode('d')))

print(Solution().is_balanced(root2))