class Graph:
    def __init__(self):
        self.graph = {}

    def add_edge(self, u, v):
        if u not in self.graph:
            self.graph[u] = []

        self.graph[u].append(v)

    def dfs_visit(self, vertex, visited):
        # Mark current vertex visited
        visited[vertex] = True
        print(vertex, end=' ')

        # Visit all the adjacent vertices
        # of current vertex
        for i in self.graph[vertex]:
            if visited[i] == False:
                self.dfs_visit(i, visited)

    def dfs(self, vertex):
        print("Tree: {}".format(self.graph))
        visited = [False] * (max(self.graph) + 1)
        self.dfs_visit(vertex, visited)


graph = Graph()
graph.add_edge(0, 1)
graph.add_edge(0, 2)
graph.add_edge(1, 2)
graph.add_edge(2, 0)
graph.add_edge(2, 3)
graph.add_edge(3, 3)
graph.add_edge(4, 0)
graph.add_edge(0, 4)

graph.dfs(2)

