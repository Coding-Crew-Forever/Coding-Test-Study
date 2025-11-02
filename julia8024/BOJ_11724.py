# 백준
# 11724. 연결 요소의 개수

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(graph, v, visited):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


# 정점의 개수 N, 간선의 개수 M
N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]

for i in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

count = 0 # 연결 노드 수
visited = [False] * (N+1)
for i in range(1, N+1):
    if not visited[i]:
        dfs(graph, i, visited)
        count += 1 # dfs 한 번 끝날 때마다 count+1

print(count)
