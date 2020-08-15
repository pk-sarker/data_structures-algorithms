from queue import Queue
class Node:
    def __init__(self, vertex, color = None, d = 1, pi = None):
        self.vertex = vertex
        self.color = color
        self.d = d
        self.pi = pi


class Graph:
    def __init__(self, vertices):
        self.G = {}
        self.G['V'] = []
        self.G['Adj'] = {}
        for v in vertices:
            self.G['V'].append(Node(v, 'WHITE', 1))

    def add_edge(self, u, v):
        if not self.G['Adj'].__contains__(u):
            self.G['Adj'][u] = []
        self.G['Adj'][u].append(Node(v, 'WHITE'))

    def BFS(self, s):
        q = Queue()
        source = Node(s, 'GRAY', 0)
        print("ENQUEUE({})".format(s))
        q.put(source)
        visited = {s: False}
        while not q.empty():
            u = q.get()
            print("DEQUEUE({})".format(u.vertex))
            if visited[u.vertex] is True:
                continue
            for v in self.G['Adj'][u.vertex]:
                if not visited.__contains__(v.vertex):
                    visited[v.vertex] = False

                if v.color == 'WHITE':
                    v.color = 'GRAY'
                    v.d = u.d+1
                    v.pi = u
                    q.put(v)
                    print("ENQUEUE({})".format(v.vertex))

            print("VISITED {} ".format(u.vertex))
            u.color = 'BLACK'
            visited[u.vertex] = True


g = Graph([0, 1, 2, 3, 4])
g.add_edge(0, 1)
g.add_edge(0, 2)
g.add_edge(1, 2)
g.add_edge(2, 0)
g.add_edge(2, 3)
g.add_edge(3, 3)
g.add_edge(4, 0)
g.add_edge(0, 4)
g.BFS(1)

# 1 2 0 3 4
