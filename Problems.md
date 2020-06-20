# Test Problems
- [Validate Binary Search Tree](#validate-binary-search-tree)



#### Validate Binary Search Tree
*Problem:*\
Given a binary tree, check if the tree is a valid binary search tree(BST).

The Binary Search Tree has the following properties: 
* Each node is represented by a Key, numeric type
* Each node may be at max two child, left and right
* The left subtree of a node(A) contains the nodes which are less than parent node(A)
* The right subtree of a node(A) contains the nodes which are greater than parent node(A)
* Both left and right subtrees must be binary search tree

**Example:**
```
a)          8 
           / \
          6  10
         / \   
        1   5

b)           8 
            / \
           6   10
               / \
              7  12

c)           8 
            / \
           6   10
          / \   
         4   9  

d)          8 
          /   \
         6     10
        / \    / \
       3   7  9  12

e)           8 
            / \
           6   10
          / \   
         4   7  

```

In the above trees a) b) c) are invalid BST. 

Tree notation: `[L N R]`; `L` - Left child, `R` - Right Child, `N` - Parent node\

Tree *a)* is invalid BST because left subtree of node `8` *[1 6 5]* is not binary search tree as right child `5` of node `6` is not greater than 6.\

Tree *b)* is invalid BST. Right subtree, *[7 10 12]*, of node `8` is BST but all the nodes in right subtree of node `8` is not greater than `8`. Node `7`, left child of node `10` is less than node `8`.\

Tree *c)* is invalid BST because all the nodes in left subtree of node `8` is not less than 8. In *[4 6 9]* is a valid BST but node `9` greater than node `8`, which implies that all the nodes in left subtree of node `8` is not smaller than `8`. \

Tree *d)* and *e)* is valid BST.

**Solution:**
For given tree where root node is *R*, 
1. check if left subtree is BST or not, and maintain a range of node values, node with lowest key and node with highest key.
2. check if the right subtree is BST or not? and maintain the same range, lowest and highest keys.
3. if highest key in the range from left subtree is less than the node *R*, and if the lowest key in the range from right subtree is greater than the node *R* then tree is BST.

[Implementation](./problems/validate_binary_search_tree.py)
  