import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
maze = [list(map(int, list(input().strip()))) for _ in range(N)]

# 상하좌우 이동
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs():
    queue = deque()
    queue.append((0, 0))
    visited = [[False]*M for _ in range(N)]
    visited[0][0] = True
    dist = [[1]*M for _ in range(N)] 
    
    while queue:
        x, y = queue.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 <= nx < N and 0 <= ny < M:
                if not visited[nx][ny] and maze[nx][ny] == 1:
                    visited[nx][ny] = True
                    dist[nx][ny] = dist[x][y] + 1
                    queue.append((nx, ny))
    return dist[N-1][M-1]

print(bfs())
