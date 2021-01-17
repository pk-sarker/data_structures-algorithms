package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * An edge in an undirected connected graph is a bridge iff removing it disconnects the graph.
 * For a disconnected undirected graph, definition is similar, a bridge is an edge removing
 * which increases number of disconnected components.
 *
 * 1) For every edge (u, v), do following
 *  a) Remove (u, v) from graph
 *  b) See if the graph remains connected (We can either use BFS or DFS)
 *  c) Add (u, v) back to the graph.
 *
 *  Time complexity of above method is O(E*(V+E)) for a graph represented using adjacency list
 *
 *  Can we do better?
 *
 *  We do DFS traversal of the given graph. In DFS tree an edge (u, v) (u is parent of v in DFS tree)
 *  is bridge if there does not exist any other alternative to reach u or an ancestor of
 *  u from subtree rooted with v.
 */
public class FindBridgeInGraph {
    /*int time = 0;
    int N = -1; // number of nodes
    List<Integer>[] adj; // adjacency list
    boolean[] visited; // keeps tract of visited vertices
    int[] discovered; // Stores discovery times of visited vertices
    int[] parent; // Stores parent vertices in DFS tree
    int[] low; // indicates earliest visited vertex reachable from subtree rooted with v

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        N = n;
        List<List<Integer>> result = new ArrayList<>();

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // adjacency matrix;
        for(int i=0; i<connections.size(); i++) {
            List<Integer> edge = connections.get(i);
            int u = edge.get(0), v = edge.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        parent = new int[N];
        visited = new boolean[N];
        discovered = new int[N];
        low = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = -1;
            visited[i] = false;
        }

        // Call the recursive helper function to find Bridges
        // in DFS tree rooted with vertex 'i'
        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                dfs(i, visited, discovered, low, parent, result);
            }
        }

        return result;
    }

    public void dfs(int u, boolean[] visited, int[] discovered, int[] low, int[] parent, List<List<Integer>> result){
        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        discovered[u] = low[u] = ++time;

        // Go through all vertices adjacent to current node, u
        List<Integer> adjVertices = adj[u];

        for(int i=0; i<adjVertices.size(); i++) {
            int v = adjVertices.get(i); // v is current adjacent of u
            // if v is not visited then make it as child of u in dfs tree, then recur
            // if v is visited then recur
            if (!visited[v]) {
                parent[v] = u;
                dfs(v, visited, discovered, low, parent, result);

                // Check if the subtree rooted with v has a
                // connection to one of the ancestors of u
                low[u]  = Math.min(low[u], low[v]);

                // If the lowest vertex reachable from subtree
                // under v is below u in DFS tree, then u-v is
                // a bridge.
                if (low[v] > discovered[u]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(u);
                    bridge.add(v);
                    result.add(bridge);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], discovered[v]);
            }
        }
    }

    */

    int N = -1;
    boolean[] visited;
    int[] low;
    int[] parent;
    int[] discovered;
    int time = 0;
    List<Integer>[] adj;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        this.N = n;
        visited = new boolean[this.N];
        low = new int[this.N];
        parent = new int[this.N];
        discovered = new int[this.N];
        adj = new ArrayList[this.N];

        for(int i=0; i<this.N; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        // create adjacency list
        for(int i = 0; i<connections.size(); i++) {
            List<Integer> edge = connections.get(i);
            int u = edge.get(0), v = edge.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        // initialize parent node and visited list
        for(int i=0; i<this.N; i++) {
            visited[i] = false;
            parent[i] = -1;
        }

        // find all bridges rooted with node i
        for(int i=0; i< this.N; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, parent, low, discovered, result);
            }
        }
        return result;
    }

    public void dfs(int u, List<Integer>[] adj, boolean[] visited, int[] parent, int[] low, int[] discovered, List<List<Integer>> result) {

        visited[u] = true;

        // set dicovery time and low value
        discovered[u] = low[u] = ++time;

        // get adjacent vertices of u
        List<Integer> adjacentVertices = adj[u];

        for(int i=0; i<adjacentVertices.size(); i++) {
            int v = adjacentVertices.get(i); // v is current adjacent of u
            // if v is not visited then make it as child of u in dfs tree
            if (!visited[v]) {
                parent[v] = u;
                dfs(v, adj, visited, parent, low, discovered, result);

                low[u] = Math.min(low[u], low[v]);

                // If the lowest vertex reachable from subtree
                // under v is below u in DFS tree, then u-v is
                // a bridge.
                if (low[v] > discovered[u]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(u);
                    bridge.add(v);
                    result.add(bridge);
                }

            } else if(v != parent[u]) {
                low[u] = Math.min(low[u], discovered[v]);
            }
        }
    }
    public static void main(String args[]) {
        FindBridgeInGraph obj = new FindBridgeInGraph();

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(){{add(0); add(1);}});
        edges.add(new ArrayList<>(){{add(1); add(2);}});
        edges.add(new ArrayList<>(){{add(2); add(0);}});
        edges.add(new ArrayList<>(){{add(1); add(3);}});
        List<List<Integer>> result = obj.criticalConnections(4, edges);
        System.out.println(result);

    }
}
