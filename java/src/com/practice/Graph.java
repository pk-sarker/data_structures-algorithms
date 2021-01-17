package com.practice;

import java.util.Iterator;
import java.util.LinkedList;


public class Graph {
    private int N = 0;
    // adjacency list
    LinkedList<Integer> [] adj = new LinkedList[]{};
    int time = 0;
    static final int NIL = -1;

    public Graph(int nodeCount) {
        N=nodeCount;
        adj = new LinkedList[nodeCount];
        for (int i=0; i<nodeCount; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // DFS based function to find all bridges. It uses recursive

    /**
     * visited[] --> keeps tract of visited vertices
     * discovered[] --> Stores discovery times of visited vertices
     * parent[] --> Stores parent vertices in DFS tree
     * low[] --> indicates earliest visited vertex reachable from subtree rooted with v
     *
     * the condition for an edge (u, v) to be a bridge is, “low[v] > disc[u]”.
     */
    void bridge(){
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[N];
        int discovered[] = new int[N];
        int low[] = new int[N];
        int parent[] = new int[N];

        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < N; i++)
        {
            parent[i] = -1;
            visited[i] = false;
        }

        // Call the recursive helper function to find Bridges
        // in DFS tree rooted with vertex 'i'
        for (int i = 0; i < N; i++) {
            if (visited[i] == false)
                dfs(i, visited, discovered, low, parent);
        }

    }

    // A recursive function that finds and prints bridges
    // using DFS traversal
    void dfs(int u, boolean[] visited, int[] discovered, int[] low, int[] parent) {
        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        discovered[u] = low[u] = ++time;

        // Go through all vertices aadjacent to this
        Iterator<Integer> itr = adj[u].iterator();

        while (itr.hasNext()) {
            int v = itr.next();  // v is current adjacent of u
            // If v is not visited yet, then make it a child
            // of u in DFS tree and recur for it.
            // If v is visited, then recur for it
            if (!visited[v])
            {
                parent[v] = u;
                dfs(v, visited, discovered, low, parent);

                // Check if the subtree rooted with v has a
                // connection to one of the ancestors of u
                low[u]  = Math.min(low[u], low[v]);

                // If the lowest vertex reachable from subtree
                // under v is below u in DFS tree, then u-v is
                // a bridge
                if (low[v] > discovered[u]) {
                    System.out.println(u + " " + v);
                }
            } // Update low value of u for parent function calls.
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], discovered[v]);
            }
        }
    }

    public static void main(String args[]){
        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(1, 3);
        g1.bridge();
    }
}
