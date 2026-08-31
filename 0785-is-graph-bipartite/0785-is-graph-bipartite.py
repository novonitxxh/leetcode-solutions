from collections import deque

class Solution:
    def isBipartite(self, graph: list[list[int]]) -> bool:
        n = len(graph)
        color = [0] * n  # 0 = uncolored, 1 = color A, -1 = color B
        
        for start in range(n):
            if color[start] != 0:
                continue
            
            color[start] = 1
            queue = deque([start])
            
            while queue:
                node = queue.popleft()
                for neighbor in graph[node]:
                    if color[neighbor] == 0:
                        color[neighbor] = -color[node]
                        queue.append(neighbor)
                    elif color[neighbor] == color[node]:
                        return False
        
        return True
        