# Searching Algorithms
- [Binary Search](#binary-search)
- [Interpolation Search](#interpolation-search)

#### Binary Search
Binary search, also known as half-interval search, logarithmic search, is a search algorithm that finds the position of a target value within a sorted array. Binary search compares the target value to the middle element of the array.
If they are not equal, the half in which the target cannot lie is eliminated and the search continues on the remaining half, again taking the middle element to compare to the target value, and repeating this until the target value is found.\
Complexity of binary search is <img src="https://render.githubusercontent.com/render/math?math=O(log_2 n)">.  where *n* is the number of elements in the array.

**Problem:**
Given an array A of *n* numbers where <img src="https://render.githubusercontent.com/render/math?math=A_0\leq A_1 \leq A_2 .... \leq A_{n-1}"> and target value T. The task is the find the position of *T* in the array.

**Solution:**
```
// Sudo code
1. Set low to 0 and high to n-1
2. if low > high then the search terminates as unsuccessfull.
3. Set mid as floor of (low + high)/2  
4. If A[mid] < T then set low = mid + 1 an go to step 2.
5. If A[mid] > T then set high = mid - 1 and go to step 2.
6. If A[mid] = T then match found, return mid
```

[Implementation](./binary_search.py)