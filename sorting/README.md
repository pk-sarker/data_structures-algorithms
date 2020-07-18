# Sorting Algorithms
- [Merge Sort](#merge-sort)

### Merge Sort
Merge sort is an efficient, general-purpose, comparison-based sorting \
algorithm. Most implementations produce a stable sort, which means that \
the order of equal elements is the same in the input and output. Merge sort \
is a divide and conquer algorithm that was invented by *John von Neumann* in 1945.\

Conceptually, a merge sort works as follows:
* Divide the unsorted list into *n* sublists, each containing one element (a list of one element is considered sorted).
* Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list.

#### Pesudocode
```
MERGE-SORT(A, p, r)
1 if p < r
2   then q ← ⌊(p + r)/2⌋
3 MERGE-SORT(A, p, q)
4 MERGE-SORT(A, q + 1, r)
5 MERGE(A, p, q, r) 


MERGE(A, p, q, r)
1  n1 ← q - p + 1
2  n2 ← r - q
3  create arrays L[1  n1 + 1] and R[1  n2 + 1]
4  for i ← 1 to n1
5      do L[i] ← A[p + i - 1]
6  for j ← 1 to n2
7      do R[j] ← A[q + j]
8  L[n1 + 1] ← ∞
9  R[n2 + 1] ← ∞
10 i ← 1
11 j ← 1
12 for k ← p to r
13     do if L[i] ≤ R[j]
14         then A[k] ← L[i]
15             i ← i + 1
16         else A[k] ← R[j]
17             j ← j + 1 
```
To perform the merging, we use an auxiliary procedure `MERGE(A, p, q, r)`, `A` is an array and `p`, `q`, and `r` are indices numbering \
 elements of the array such that `p ≤ q < r`. The procedure assumes that the sub-arrays `A[p  q]` and `A[q + 1  r]` are in sorted order. 
It merges them to form a single sorted subarray that replaces the current subarray `A[p  r]`

In detail, the `MERGE` procedure works as follows. Line 1 computes the length `n1` of the
subarray `A[p  q]`, and line 2 computes the length `n2` of the subarray `A[q + 1  r]`. We create
arrays `L` and `R` ("left" and "right"), of lengths `n1 + 1` and `n2 + 1`, respectively, in line 3. The for
loop of lines 4-5 copies the subarray `A[p  q]` into `L[1  n1]`, and the for loop of lines 6-7
copies the subarray `A[q + 1  r]` into `R[1  n2]`. Lines 8-9 put the sentinels at the ends of the
arrays `L` and `R`. Lines 10-17, illustrated in Figure, perform the `r - p + 1` basic steps by
maintaining the following loop invariant:
* At the start of each iteration of the for loop of lines 12-17, the subarray `A[p  k - 1]`
contains the `k - p` smallest elements of `L[1  n1 + 1]` and `R[1  n2 + 1]`, in sorted
order. Moreover, `L[i]` and `R[j]` are the smallest elements of their arrays that have not
been copied back into `A`.
