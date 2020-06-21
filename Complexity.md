# Time and Space Complexity
For a given problem, there might be different ways to solve it. To find the better approach it is required to analyze the algorithms in terms of performance.\
Mostly Time and Space complexity is considered for performance analysis. Time complexity of an algorithm quantifies the time required by an algorithm to run as a function of the length of the input. \
Space complexity of an algorithm quantifies the amount of space or memory taken by an algorithm to run as a function of the length of the input.

***Order*** of growth is how the time of execution depends on the length of the input. Order of growth will help us to compute the running time with ease. We will ignore the lower order terms, since the lower order terms are relatively insignificant for large input. We use different notation to describe limiting behavior of a function.

<img src="https://render.githubusercontent.com/render/math?math=O">-notation:
To denote asymptotic upper bound, we use <img src="https://render.githubusercontent.com/render/math?math=O">-notation. For a given function <img src="https://render.githubusercontent.com/render/math?math=g(n)">, we denote by <img src="https://render.githubusercontent.com/render/math?math=O(g(n))">(pronounced “big-oh of g of n”) the set of functions:
<img src="https://render.githubusercontent.com/render/math?math=O(g(n)) = f(n) : " > _there exist positive constants_ _c_  and <img src="https://render.githubusercontent.com/render/math?math=n_0" > such that <img src="https://render.githubusercontent.com/render/math?math=0\leq f(n) \leq c * g(n)" > for all <img src="https://render.githubusercontent.com/render/math?math=n \leq n_0">

<img src="https://render.githubusercontent.com/render/math?math=\Omega">-notation:
To denote asymptotic lower bound, we use <img src="https://render.githubusercontent.com/render/math?math=\Omega">-notation. For a given function <img src="https://render.githubusercontent.com/render/math?math=g(n)">, we denote by <img src="https://render.githubusercontent.com/render/math?math=\Omega(g(n))"> (pronounced “big-omega of g of n”) the set of functions:

<img src="https://render.githubusercontent.com/render/math?math=\Omega(g(n)) = f(n) : \text{there exist positive constants}"> _c_ and <img src="https://render.githubusercontent.com/render/math?math=n_0" > such that <img src="https://render.githubusercontent.com/render/math?math=0 \leq c * g(n) \leq f(n)" > for all <img src="https://render.githubusercontent.com/render/math?math=n \leq n_0">

<img src="https://render.githubusercontent.com/render/math?math=\Theta">-notation:
To denote asymptotic lower bound, we use <img src="https://render.githubusercontent.com/render/math?math=\Theta">-notation. For a given function <img src="https://render.githubusercontent.com/render/math?math=g(n)">, we denote by <img src="https://render.githubusercontent.com/render/math?math=\Theta(g(n))"> (pronounced “big-theta of g of n”) the set of functions:

<img src="https://render.githubusercontent.com/render/math?math=\Theta(g(n)) = f(n) : \text{there exist positive constants}"> <img src="https://render.githubusercontent.com/render/math?math=c_1, c_2, \text{and }n_0" > such that <img src="https://render.githubusercontent.com/render/math?math=0 \leq c_1 * g(n) \leq f(n) \leq c_2 * g(n)" > for all <img src="https://render.githubusercontent.com/render/math?math=n \leq n_0">

![Complexity](./images/complexity.jpg)

**Linear-**<img src="https://render.githubusercontent.com/render/math?math=O(n)">:
Most optimal algorithms run in linear time. An easy way to identify this is to determine if you're accessing/visiting every input/node/item once and only once.  If you are, it is linear... it doesn't matter how many operations you're doing whether it's 1, 2, 3, or 4 lines of code you're executing per node.  Generally, you are still doing a constant amount of work per input.


**Constant-**<img src="https://render.githubusercontent.com/render/math?math=O(k)">:
A constant time algorithm have a running time independent of the input size. An algorithm is said to be constant time (also written as <img src="https://render.githubusercontent.com/render/math?math=O(1)"> time) if the value of <img src="https://render.githubusercontent.com/render/math?math=T(n)"> is bounded by a value that does not depend on the size of the input.

**Logarithmic-**<img src="https://render.githubusercontent.com/render/math?math=O(log(n))">:
An algorithm is said to take logarithmic time when <img src="https://render.githubusercontent.com/render/math?math=T(n)=O(log (n))">. Since <img src="https://render.githubusercontent.com/render/math?math=log_an"> and <img src="https://render.githubusercontent.com/render/math?math=log_bn"> are related by a constant multiplier, and such a multiplier is irrelevant to big-O classification, the standard usage for logarithmic-time algorithms is <img src="https://render.githubusercontent.com/render/math?math=O(log (n))"> regardless of the base of the logarithm appearing in the expression of T.
Logarithmic algorithms are often seen in trees.  It's best to think of "logarithmic" as the "height of the tree."  So, a binary search, for instance, often includes traversing down the height of a tree and can be considered logarithmic in time.  (Although, it may still be more accurate to say that for an unbalanced tree, the runtime is in the worst case linear.)  

**Quasilinear**-<img src="https://render.githubusercontent.com/render/math?math=O(n*log(n))">:  
An algorithm is said to run in quasilinear time (also referred to as log-linear time) if <img src="https://render.githubusercontent.com/render/math?math=T(n)=O(n log^k n)"> for some positive constant *k*; linearithmic time is the case <img src="https://render.githubusercontent.com/render/math?math=k=1">.
Algorithms which run in quasilinear time include:
* In-place merge sort, <img src="https://render.githubusercontent.com/render/math?math=O(n log^2 n)">
* Quicksort, <img src="https://render.githubusercontent.com/render/math?math=O(n log n)">, in its randomized version, has a running time that is <img src="https://render.githubusercontent.com/render/math?math=O(n log n)"> in expectation on the worst-case input. Its non-randomized version has an <img src="https://render.githubusercontent.com/render/math?math=O(n log n)"> running time only when considering average case complexity.
* Heapsort, <img src="https://render.githubusercontent.com/render/math?math=O(n log n)">, merge sort, introsort, binary tree sort, smoothsort, patience sorting, etc. in the worst case
* Fast Fourier transforms, <img src="https://render.githubusercontent.com/render/math?math=O(n log n)">
* Monge array calculation, <img src="https://render.githubusercontent.com/render/math?math=O(n log n)">

**Quadratic or Cubic** - <img src="https://render.githubusercontent.com/render/math?math=O(n^2)"> or <img src="https://render.githubusercontent.com/render/math?math=O(n^3)">:\
An algorithm is said to be quadratic time if <img src="https://render.githubusercontent.com/render/math?math=T(n)=O(n^2)">, and for cubic <img src="https://render.githubusercontent.com/render/math?math=T(n)=O(n^3)">. Brute force algorithms often takes quadratic or cubic time.

**Polynomial** - <img src="https://render.githubusercontent.com/render/math?math=O(n^k)">:\
An algorithm is said to be of polynomial time if its running time is upper bounded by a polynomial expression in the size of the input for the algorithm, i.e., <img src="https://render.githubusercontent.com/render/math?math=T(n)=O(n^k)"> for some positive constant *k*.

**Exponential time**:\
An algorithm is said to be exponential time, if <img src="https://render.githubusercontent.com/render/math?math=T(n)"> is upper bounded by <img src="https://render.githubusercontent.com/render/math?math=2^poly(n)">, where <img src="https://render.githubusercontent.com/render/math?math=poly(n)"> is some polynomial in *n*. More formally, an algorithm is exponential time if <img src="https://render.githubusercontent.com/render/math?math=T(n)"> is bounded by <img src="https://render.githubusercontent.com/render/math?math=O(2^{n^k})"> for some constant *k*. 
Sometimes, exponential time is used to refer to algorithms that have <img src="https://render.githubusercontent.com/render/math?math=T(n)=2^{O(n)}">, where the exponent is at most a linear function of n. 

**Factorial time**:\
These algorithms are the slowest and don't show up that often.  You might see this in combinatorial problems, or like a "traveling salesman" problem where given n nodes, you need to find the optimal path from start to finish.\
In your first iteration, you have a selection of *n* cities to visit, then *n-1* cities, then *n-2* cities, *n-3* cities, etc., until you reach the last city. That runtime is <img src="https://render.githubusercontent.com/render/math?math=n * (n -1 ) * (n - 2) * (n -3 ) ... 1 = O(n!)">.

![Time Complexity Curve](./images/complexity-curve-pijus.png)