import sys
from collections import deque

input = sys.stdin.readline

N, M, K, X = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)

distance = [-1] * (N+1)
distance[X] = 0

queue = deque([X])
while queue:
    now = queue.popleft()
    for next_node in graph[now]:
        if distance[next_node] == -1:
            distance[next_node] = distance[now] + 1
            queue.append(next_node)

answer = []
for i in range(1, N+1):
    if distance[i] == K:
        answer.append(i)

if answer:
    for city in sorted(answer):
        print(city)
else:
    print(-1)
