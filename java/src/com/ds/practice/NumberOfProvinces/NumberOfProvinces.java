package com.ds.practice.NumberOfProvinces;

public class NumberOfProvinces {

    public void DFS(int[][] M, int[] visited, int startNode) {
        for(int j=0; j<M.length;j++) {
            if (M[startNode][j]==1 && visited[j] == 0) {
                visited[j]=1;
                DFS(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;

        for(int i=0; i<M.length; i++) {
            if (visited[i] == 0) {
                DFS(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        NumberOfProvinces fc = new NumberOfProvinces();

        int[][] m = new int[][]{{1,1,0},
                {1,1,0},
                {0,0,1}};

        System.out.println(fc.findCircleNum(m));

        int[][] n = new int[][]{{1,0,0},
                {0,1,0},
                {0,0,1}};
        System.out.println(fc.findCircleNum(n));

    }
}
