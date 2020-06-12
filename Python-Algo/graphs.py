from collections import defaultdict

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        self.graph[u].append(v)
        self.graph[v].append(u)
        self.graph[v].remove(u)

    def use(self, v):
        print(v)

    def breitensuche(self, start):
        visited = [False] * len(self.graph)
        queue = [start]
        visited[start] = True

        while len(queue) > 0:
            start = queue.pop(0)
            self.use(start)
            for i in self.graph[start]:
                if visited[i]:
                    continue
                queue.append(i)
                visited[i] = True

    def _tiefensuche(self, v, visited):
        visited[v] = True
        self.use(v)
        for i in self.graph[v]:
            if not visited[i]:
                self._tiefensuche(i, visited)

    def tiefensuche(self, start):
        visited = [False]*len(self.graph)
        print(self.graph)
        self._tiefensuche(start, visited)


g = Graph()
g.add_edge(0,2)
g.add_edge(0,4)
g.add_edge(2,4)
g.add_edge(1,3)
g.add_edge(4,1)
g.add_edge(4,0)
g.add_edge(4,2)
print("Starte Breitensuche")
g.breitensuche(0)
print("Starte Tiefensuche")
g.tiefensuche(0)
