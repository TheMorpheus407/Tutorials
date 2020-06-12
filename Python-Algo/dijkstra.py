import sys
from collections import deque, namedtuple

Edge = namedtuple('Edge', 'start, end, cost')
def create_edge(start, end, cost):
    return Edge(start, end, cost)

class Graph:
    def __init__(self, edges):
        self.edges = [create_edge(*e) for e in edges]

    def vertices(self):
        return set(
            e.start for e in self.edges
        ).union(e.end for e in self.edges)

    def get_neighbour(self, v):
        neighbours = []
        for e in self.edges:
            if e.start == v:
                neighbours.append((e.end, e.cost))
        return neighbours

    def path(self, source, destination, prev_v):
        path = []
        curr_v = destination
        while prev_v[curr_v] is not None:
            path.insert(0, curr_v)
            curr_v = prev_v[curr_v]
        path.insert(0, curr_v)
        return path

    def dijkstra(self, source, destination):
        distances = {v: float("inf") for v in self.vertices()}
        prev_v = {v: None for v in self.vertices()}

        distances[source] = 0
        vertices = list(self.vertices())[:]
        while len(vertices) > 0:
            v = min(vertices, key=lambda u: distances[u])
            vertices.remove(v)
            if distances[v] == float("inf"):
                break
            for neighbour, cost in self.get_neighbour(v):
                path_cost = distances[v] + cost
                if path_cost < distances[neighbour]:
                    distances[neighbour] = path_cost
                    prev_v[neighbour] = v
        return self.path(source, destination, prev_v)

    def bellman_ford(self, source):
        distances = {v: float("inf") for v in self.vertices()}
        prev_v = {v: None for v in self.vertices()}
        distances[source] = 0

        for i in range(len(self.vertices())-1):
            for (u, v, c) in self.edges:
                if distances[u] != float("inf") and distances[u] + c < distances[v]:
                    distances[v] = distances[u] + c
                    prev_v[v] = u

        for (u, v, c) in self.edges:
            if distances[u] != float("inf") and distances[u] + c < distances[v]:
                print("Graph enthält negative Zyklen")
                return

        return distances, prev_v

    def root(self, parents, v):
        if parents[v] == v:
            return v
        return self.root(parents, parents[v])

    def union(self, parents, u, v):
        u_root = self.root(parents, u)
        v_root = self.root(parents, v)
        parents[u_root] = v_root

    def kruskal(self):
        mst = []
        self.edges = sorted(self.edges, key=lambda i: i[2])
        prev_v = {v: v for v in self.vertices()}
        amount_edges = 0

        i = 0
        while amount_edges < len(self.vertices())-1:
            u, v, c = self.edges[i]
            i = i+1
            parent_u = self.root(prev_v, u)
            parent_v = self.root(prev_v, v)

            if parent_u != parent_v:
                amount_edges = amount_edges + 1
                mst.append([u, v, c])
                self.union(prev_v, u, v)
        return mst

if __name__ == "__main__":
    graph = Graph([
        ("a", "b", 2),("a", "c", 4),("b", "c", 5),
        ("b", "d", 4),("b", "e", 9),("c", "e", 1),
        ("d", "e", 2),("c", "g", 2),("c", "h", 7),
        ("g", "h", 3),("g", "f", 1),("h", "j", 5),
        ("g", "j", 8),("f", "i", 2),("i", "j", 6),
        ("g", "i", 6)
    ])
    #distances, prev_v = graph.bellman_ford("a")
    #print(graph.path("a", "i", prev_v))
    #print(graph.dijkstra())
    print(graph.kruskal())
