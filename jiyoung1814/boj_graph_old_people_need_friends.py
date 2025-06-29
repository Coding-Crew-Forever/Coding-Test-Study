import sys
from collections import deque
input = sys.stdin.readline

def bfs(row, col, graph, visited):
    cnt = 0
    move = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    queue = deque()
    queue.append((row, col))

    visited[row][col] = 1

    while queue:
        r, c = queue.popleft()
        for i in range(4):
            nr = r + move[i][0]
            nc = c + move[i][1]

            if nr < 0 or nr >= n or nc < 0 or nc >= m: # 벽 밖으로 나간다면
                continue
            if graph[nr][nc] == 'X':
                continue
            if visited[nr][nc] == 1:
                continue
            visited[nr][nc] = 1
            queue.append((nr, nc))
            if graph[nr][nc] == 'P':
                cnt += 1

    return cnt

n, m = map(int, input().split())
graph = [list(input().strip()) for _ in range(n)]

visited = [[0] * m for _ in range(n)]


start = (0, 0)
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'I':
            start = (i, j)


cnt = bfs(start[0], start[1], graph, visited)

if cnt == 0:
    print("TT")
if cnt != 0:
    print(cnt)