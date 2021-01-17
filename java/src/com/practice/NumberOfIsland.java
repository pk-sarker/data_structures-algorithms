package com.practice;

/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class NumberOfIsland {

    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j]=='0') {
            return;
        }

        grid[i][j] = '0';

        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {

                if (grid[i][j]=='1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        NumberOfIsland noi = new NumberOfIsland();
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(noi.numIslands(grid));

        char[][] grid2 = new char[][]{
                {'1','1','0','1','0'},
                {'0','1','0','1','0'},
                {'1','0','0','1','1'},
                {'1','0','1','0','0'}
        };
        System.out.println(noi.numIslands(grid2));
    }
}
