import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    W, H, K = map(int, input().split())
    graph = [[0] * H for _ in range(W)]
    visited = [[0] * H for _ in range(W)]
    answer = 0

    # 배추 위치 설정
    for _ in range(K):
        x, y = map(int, input().split())
        graph[x][y] = 1

    # DFS 함수
    def dfs(nowX, nowY):
        visited[nowX][nowY] = 1
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # 상하좌우
        for dx, dy in directions:
            nextX = nowX + dx
            nextY = nowY + dy
            if 0 <= nextX < W and 0 <= nextY < H:
                if graph[nextX][nextY] == 1 and not visited[nextX][nextY]:
                    dfs(nextX, nextY)

    # 모든 좌표 순회
    for x in range(W):
        for y in range(H):
            if graph[x][y] == 1 and not visited[x][y]:
                dfs(x, y)
                answer += 1

    print(answer)
