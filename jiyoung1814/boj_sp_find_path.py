import sys

def floyd_warshall(n, graph):
    # 플로이드-워셜 알고리즘
    for k in range(n):  # 중간 정점
        for i in range(n):  # 시작 정점
            for j in range(n):  # 도착 정점
                if graph[i][k] == 1 and graph[k][j] == 1:
                    graph[i][j] = 1
    return graph

n = int(sys.stdin.readline().strip())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

result = floyd_warshall(n, graph)

for row in result:
    print(" ".join(map(str, row)))