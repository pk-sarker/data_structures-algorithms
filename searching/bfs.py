# Breath-first Search
#
from queue import Queue

class Graph:
    def __init__(self):
        self.adjacency_list = {}

    def add_edge(self, node_a, node_b):
        if not self.adjacency_list.__contains__(node_a):
            self.adjacency_list[node_a] = []

        self.adjacency_list[node_a].append(node_b)

    def print_list(self):
        print(self.adjacency_list)

    def bfs(self, source):
        q = Queue()
        visited = {source: False}
        q.put(source)
        while not q.empty():
            node = q.get()
            if visited[node] is True:
                continue
            print(node, end=" ")
            visited[node] = True
            if self.adjacency_list[node] is None:
                continue
            for n in self.adjacency_list[node]:
                q.put(n)
                if n not in visited:
                    visited[n] = False


if __name__ == "__main__":

    graph = Graph()
    graph.add_edge(0, 1)
    graph.add_edge(0, 2)
    graph.add_edge(1, 2)
    graph.add_edge(2, 0)
    graph.add_edge(2, 3)
    graph.add_edge(3, 3)
    graph.add_edge(4, 0)
    graph.add_edge(0, 4)
    # graph.add_edge(0, 1)
    # graph.add_edge(0, 1)

    graph.print_list()

    graph.bfs(1)

