# Tree
## Table of Contents
- [Definitions](#definitions)
- [Problems](#problems)
    - [Create a binary tree](#create-a-binary-tree)
    - [Construct a complete binary tree in level order](#construct-a-complete-binary-tree-in-level-order)
    - [Create a binary tree](#create-a-binary-tree)


## Definitions
####  Rooted Binary Tree
A rooted binary tree has a root node and every node has at most two children.

#### Full Binary Tree
A full binary tree is a tree in which every node has either 0 or 2 children. 
Another way of defining a full binary tree is a recursive definition. A full binary tree is either:
* A single vertex.
* A tree whose root node has two subtrees, both of which are full binary trees.

The number of nodes *n* in a full binary tree, is at least <img src="https://latex.codecogs.com/gif.latex?n=2h+1" /> and at-most <img src="https://latex.codecogs.com/gif.latex?n=2^{h+1}-1" /> where *h* is the height of the tree. 
A tree consisting of only a root node has a height of *0*.

A full binary tree with *l* leaves has <img src="https://latex.codecogs.com/gif.latex?n=2l-1" /> nodes.

#### Complete Binary Tree
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2^h nodes at the last level *h*. 

The number of internal nodes in a complete binary tree of *n* nodes is <img src="https://latex.codecogs.com/gif.latex?n/2" />.


#### Perfect Tree
A perfect binary tree is a binary tree in which all interior nodes have two children and all leaves have the same depth or same level.

The number of leaf nodes *l* in a perfect binary tree, is  <img src="https://latex.codecogs.com/gif.latex?l=(n+1)/2" /> because the number of non-leaf (a.k.a. internal) nodes
![ScreenShot](perfect_tree_eq1.png)

In a perfect full binary tree, <img src="https://latex.codecogs.com/gif.latex?l=2^h" /> thus <img src="https://latex.codecogs.com/gif.latex?n=2^{h+1}-1" />

#### Balanced Binary Tree
A binary tree is balanced if the height of the tree is <img src="https://latex.codecogs.com/gif.latex?O(Log n)" /> where *n* is the number of nodes. 

#### Complete Binary Tree: 
A Binary Tree is complete Binary Tree if all levels are completely filled except possibly the last level and the last level has all keys as left as possibleA balanced binary tree is a binary tree structure in which the left and right subtrees of every node differ in height by no more than 1.

* The maximum number of nodes at level `L` of a binary tree is <img src="https://latex.codecogs.com/gif.latex?2^{L-1}" />
* Maximum number of nodes in a binary tree of height `H` is <img src="https://latex.codecogs.com/gif.latex?2^{H}-1" />

## Problems
### Create a binary tree
**Problem**:
Given an array of elements, sorted in ascending order, task is to construct a complete binary tree from this array using level order approach.

**Time Complexity**\
Each node will be traversed once, so the time complexity is `O(n)`

**Space Complexity**\
`O(n)`

[Implementation](./create_binary_tree.py)

### Construct a complete binary tree in level order
**Problem**:
Given an array of elements, task is to construct a complete binary tree from this array in level order.

Example: 
```
Input: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Tree:              1
                /     \
               2       3
              / \     / \
             4   5   6   7
            / \  /
           8  9 10
In Order:
8 4 9 2 10 5 1 6 3 7
```
**Solution**:
We need a generic logic to pick left and right child of a parent node from array.
If parent is at index *i* then pick *2 x i + 1* as left child and *2 x i + 2* as right child. Repeatedly apply this logic until all the elements in the list are picked up.

**Time Complexity**\
`O(n)`

**Space Complexity**\
`O(n)`

[Implementation](./create_binary_tree_in_level_order.py)

# Reference
* Wikipedia, https://en.wikipedia.org/wiki/Binary_tree