# 백준
# 11725. 트리의 부모 찾기

import sys
from collections import deque

N = int(sys.stdin.readline())
graph = [[] for i in range(N+1)]
for _ in range(N-1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

queue = deque()
queue.append(1)

result = [0]*(N+1)

def bfs():
    while queue:
        now = queue.popleft()
        for nxt in graph[now]:
            if result[nxt] == 0:
                result[nxt] = now
                queue.append(nxt)

bfs()

print("\n".join(map(str, result[2:])))
