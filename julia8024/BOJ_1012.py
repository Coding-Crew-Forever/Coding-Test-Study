# 백준
# 실버2 유기농 배추

import sys
sys.setrecursionlimit(10**6) # 재귀 최대 깊이 설정

def dfs(x, y):
    # 상하좌우
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]

    # 네 방향 탐색
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        # 범위 안에 있고 1이면(배추이면) 지나간 것을 -1로 표시한 후 주변 탐색
        if (0 <= nx < m) and (0 <= ny < n) and graph[ny][nx] == 1:
            graph[ny][nx] = -1
            dfs(nx, ny)

t_case = int(sys.stdin.readline()) # 테스트 케이스 개수

for _ in range(t_case):
    m, n, k = map(int, sys.stdin.readline().split()) # 가로, 세로, 배추 개수
    graph = [[0 for _ in range(m)] for _ in range(n)]

    # 배추 위치 표시
    for _ in range(k):
        X, Y = map(int, sys.stdin.readline().split())
        graph[Y][X] = 1

    # 배추 그룹 수(배추흰지렁이 개수) 세기
    cnt = 0
    for a in range(m):
        for b in range(n):
            if graph[b][a] == 1:
                dfs(a ,b)
                cnt += 1
    print(cnt)
