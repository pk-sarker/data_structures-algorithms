package com.practice;

/**
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected
 * directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and
 * no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1
 * if the ith city and the jth city are directly connected, and
 * isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 */
public class NumberOfProvinces {
    int[] visited;
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        visited = new int[isConnected.length];
        for(int i=0;i<isConnected.length; i++){
            visited[i] = 0;
        }

        // run DFS from every node to find all the connected components.
        // recursive DFS calls from directly and indirectly connected nodes
        // ensure to explore/visit all reachable nodes.
        for(int i=0; i<isConnected.length; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(isConnected, visited, i);
            }
        }
        return count;
    }

    public void dfs(int[][] adj, int[] visited, int startNode) {

        visited[startNode] = 1;
        int[] neighbors = adj[startNode];

        for(int j=0; j<adj.length; j++) {
            // if there is any edge between startnode and j th node: adj[startNode][j] == 1
            if  (adj[startNode][j] == 1 && visited[j]==0) {
                visited[j] = 1;
                dfs(adj, visited, j);
            }
        }


    }

    public static void main(String args[]) {
        NumberOfProvinces np = new NumberOfProvinces();
        int[][] m = new int[][]{{1,1,0},
                {1,1,0},
                {0,0,1}};

        System.out.println(np.findCircleNum(m));

        int[][] n = new int[][]{{1,0,0},
                {0,1,0},
                {0,0,1}};
        System.out.println(np.findCircleNum(n));
    }
}
