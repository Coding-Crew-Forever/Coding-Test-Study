import sys
sys.setrecursionlimit(10000)
def dfs(graph, v, visited):
    visited[v] = True

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


n, m = map(int, sys.stdin.readline().split()) # 정점의 개수, 간선의 개수
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n+1)
cnt = 0

for i in range(1, n+1):
    if not visited[i]:
        if not graph[i]:
            cnt += 1
            visited[i] = True

        else:
            dfs(graph, i, visited)
            cnt +=1

print(cnt)
