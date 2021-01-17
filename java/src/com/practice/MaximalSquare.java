package com.practice;

/**
 * Given an m x n binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * Input: matrix = [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]]
 * Output: 4
 */
public class MaximalSquare {

    /**
     * The simplest approach consists of trying to find out every possible square of 1’s that can be
     * formed from within the matrix.
     *
     * We use a variable to contain the size of the largest square found so far and another variable
     * to store the size of the current, both initialized to 0. Starting from the left uppermost point
     * in the matrix, we search for a 1. No operation needs to be done for a 0. Whenever a 1 is found,
     * we try to find out the largest square that can be formed including that 1
     *
     * For this, we move diagonally (right and downwards), i.e. we increment the row index and column
     * index temporarily and then check whether all the elements of that row and column are 1 or not.
     * If all the elements happen to be 1, we move diagonally further as previously. If even one element
     * turns out to be 0, we stop this diagonal movement and update the size of the largest square. Now
     * we, continue the traversal of the matrix from the element next to the initial 1 found, till all
     * the elements of the matrix have been traversed.
     *
     * Complexity Analysis
     * Time complexity : O((mn)^2). In worst case, we need to traverse the complete matrix for every 1.
     * Space complexity : O(1). No extra space is used.
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length:0;
        int maxLen = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if (matrix[i][j]=='1') {
                    int len = 1;
                    boolean flag = true;
                    // why i+len?
                    // initially if there is one 1 then the square size of the square is 1
                    // if square size is 2, then we need to make sure that
                    // all the elements at 2 distance (current row + len & current column + len)
                    // are 1, if not then it is not size 2 square
                    // example
                    // '1' '1'      '1' '1'
                    // '1' '1'      '0' '1'
                    while(i+len < rows && j+len < cols && flag) {
                        for(int k=j; k<= j + len; k++) {
                            if (matrix[i+len][k]=='0') {
                                flag = false;
                                break;
                            }
                        }

                        for(int k=i; k<= i + len; k++) {
                            if (matrix[k][j+len]=='0') {
                                flag = false;
                                break;
                            }
                        }

                        if (flag) {
                            len++;
                        }
                    }
                    if (maxLen < len) {
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen*maxLen;
    }

    /**
     * We initialize another matrix (dp) with the same dimensions as the original one initialized
     * with all 0’s.
     *
     * dp(i,j) represents the side length of the maximum square whose bottom right corner is the cell
     * with index (i,j) in the original matrix.
     *
     * Starting from index (0,0), for every 1 found in the original matrix, we update the value of the
     * current element as
     * dp[i][j] = min ( dp[i-1][j], dp[i-1][j-1], dp[i][j-1] ) + 1
     *
     * We also remember the size of the largest square found so far. In this way, we traverse the original
     * matrix once and find out the required maximum size. This gives the side length of the square
     * (say maxsqlenmaxsqlen). The required result is the area maxsqlen^2maxsqlen
     * 2
     *
     * To understand how this solution works, see the figure below.
     *
     *
     * @param matrix
     * @return
     */
    public static int maximalSquareOptimized(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length:0;
        int maxLen = 0;
        int[][] dp = new int[rows+1][cols+1];

        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=cols; j++) {
                if (matrix[i-1][j-1]=='1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }

    public static void main(String args[]) {
        char[][] mat = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println("Expected output: 4, actual: " + MaximalSquare.maximalSquare(mat));


        char[][] mat2 = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','1','1','1'}};
        System.out.println("Expected output: 9, actual: " + MaximalSquare.maximalSquare(mat2));

        char[][] mat3 = new char[][]{
                {'0','0'},
                {'0','0'}};
        System.out.println("Expected output: 0, actual: " + MaximalSquare.maximalSquare(mat3));

        char[][] mat4 = new char[][]{
                {'1','1'},
                {'1','1'}};
        System.out.println("Expected output: 4, actual: " + MaximalSquare.maximalSquare(mat4));

        char[][] mat5 = new char[][]{
                {'1'}};
        System.out.println("Expected output: 1, actual: " + MaximalSquare.maximalSquare(mat5));

        char[][] mat6 = new char[][]{
                {'0'}};
        System.out.println("Expected output: 0, actual: " + MaximalSquare.maximalSquare(mat6));



        char[][] mat7 = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println("Expected output: 4, actual: " + MaximalSquare.maximalSquareOptimized(mat7));


        char[][] mat8 = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','1','1','1'}};
        System.out.println("Expected output: 9, actual: " + MaximalSquare.maximalSquareOptimized(mat8));

    }

}
