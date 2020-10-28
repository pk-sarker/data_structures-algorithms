package com.ds.practice.CountIslands;

public class CountIslands {

    public void traverseDFS(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c]=='0') {
            return;
        }

        grid[r][c] = '0';
        traverseDFS(grid, r, c+1);
        traverseDFS(grid, r, c-1);
        traverseDFS(grid, r+1, c);
        traverseDFS(grid, r-1, c);
    }

    public int countIsland(char[][] grid) {
        int count = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        for (int i=0; i<nr; i++) {
            for (int j=0;j<nc;j++) {
                if (grid[i][j]=='1') {
                    count++;
                    traverseDFS(grid, i, j);
                }
            }
        }

        return count;
    }
    public static void main(String args[]) {
        CountIslands ci = new CountIslands();
        char[][] grid = new char[][]
                { {'1','1','1','1','0'},
                  {'1','1','0','1','0'},
                  {'1','1','0','0','0'},
                  {'0','0','0','0','0'}
                };
        System.out.println(ci.countIsland(grid));

        char[][] grid2 = new char[][]
                { {'1','1','0','0','0'},
                  {'1','1','0','0','0'},
                  {'0','0','1','0','0'},
                  {'0','0','0','1','1'}
                };
        System.out.println(ci.countIsland(grid2));
    }
}
