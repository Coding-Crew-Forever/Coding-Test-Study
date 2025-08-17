import sys

input = sys.stdin.readline

cnt = 0
N = int(input().strip())
M = int(input().strip())

node = [[0] * (N + 1) for _ in range(N + 1)]
visited = [False] * (N + 1)

for _ in range(M):
    a, b = map(int, input().split())
    node[a][b] = node[b][a] = 1

def dfs(start: int):
    global cnt
    visited[start] = True
    cnt += 1
    for i in range(1, N + 1):
        if node[start][i] == 1 and not visited[i]:
            dfs(i)

dfs(1)
print(cnt - 1)  # 1번 컴퓨터 제외
