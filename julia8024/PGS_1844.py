# 프로그래머스
# Lv2 게임 맵 최단거리

from collections import deque

def solution(maps):
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    
    n, m = len(maps), len(maps[0])
    
    visited = [[False] * m for _ in range(n)]
    queue = deque([(0,0,1)])
    visited[0][0] = True

    while queue:
        x, y, cnt = queue.popleft()
        if x == n - 1 and y == m - 1:
            return cnt
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny, cnt + 1))
    return -1
