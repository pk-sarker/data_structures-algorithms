# Problem:
# Given list of elements by traversing a tree in-order and pre-order, task is to construct a  tree from
# these two list.
#
# Examples:
# Input:
# In-order: (L P R ) arr[]  = {4, 2, 5, 1, 6, 3}
# Pre-order: (P L R)  arr[] = {1, 2, 4, 5, 3, 6}
#
# Output : Root of the following tree
#                   1
#                  / \
#                 2   3
#                / \ /
#               4  5 6
# In-order traversal: 4 2 5 1 6 3
#
# Input: arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
# In-order: (L P R ) arr[]  = {8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 3, 7}
# Pre-order: (P L R)  arr[] = {1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 7}
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


def construct_tree(pre_order, in_order, start, end, in_order_map):

    if start > end:
        return None

    current_node = Node(pre_order[construct_tree.pre_order_index])

    construct_tree.pre_order_index += 1

    if start == end:
        return current_node

    index_in_in_order = in_order_map.get(current_node.data)

    # for i in range(start, end + 1):
    #     if in_order[i] == current_node.data:
    #         index_in_in_order = i
    #         #break

    #print("\n Node: ", current_node.data, index_in_in_order)
    current_node.left = construct_tree(pre_order, in_order, start, index_in_in_order-1, in_order_map)
    current_node.right = construct_tree(pre_order, in_order, index_in_in_order+1, end, in_order_map)

    return current_node


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


if __name__ == "__main__":
    in_order = [4, 2, 5, 1, 6, 3]
    pre_order = [1, 2, 4, 5, 3, 6]

    in_order_map = dict()

    for i in range(0, len(in_order)):
        in_order_map[in_order[i]] = i


    root = None
    # root = insert_node_in_level_order(arr, root, 0, len(arr))
    construct_tree.pre_order_index = 0
    root = construct_tree(pre_order, in_order, 0, len(pre_order)-1, in_order_map)
    print("In-order: \n")
    traverse_in_order(root)
    print("\nPre-order: \n")
    traverse_pre_order(root)

    print("\n Test 2:")
    in_order_map = dict()
    in_order = [8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 3, 7]
    pre_order = [1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 7]
    root = None
    for i in range(0, len(in_order)):
        in_order_map[in_order[i]] = i
    construct_tree.pre_order_index = 0
    root = construct_tree(pre_order, in_order, 0, len(pre_order) - 1, in_order_map)

    print("In-order: \n")
    traverse_in_order(root)
    print("\nPre-order: \n")
    traverse_pre_order(root)