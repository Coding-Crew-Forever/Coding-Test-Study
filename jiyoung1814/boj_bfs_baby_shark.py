import sys
from collections import deque
BABY_SHARK = 9

input = sys.stdin.readline
move = [(-1, 0), (0, -1), (1, 0), (0, 1)] # 상, 좌, 하, 우

def bfs(arr, start):
    bs = 2 # 시작 크기
    eaten = 0 # 먹은 물고기
    help_time = 0

    pos = start

    while True:

        queue = deque([(pos[0], pos[1], 0)]) # r, c, distant

        visited = [[False] * len(arr[0]) for _ in range(len(arr))]
        visited[pos[0]][pos[1]] = True

        fishes = []

        while queue:
            r, c, d = queue.popleft()
            for pr, pc in move:
                nr, nc = r + pr, c + pc
                if 0 <= nr < len(arr) and 0 <= nc < len(arr[0]) and not visited[nr][nc]:
                    if arr[nr][nc] <= bs: # 물고기 크기가 작거나 같다면
                        visited[nr][nc] = True
                        queue.append((nr, nc, d+1))
                        if 0 < arr[nr][nc] < bs: # 물고기 크기가 작다면
                            fishes.append((d + 1, nr, nc))

        if not fishes:
            break

        fishes.sort() # 거리, 위, 왼 순 정렬

        f_d, f_r, f_c = fishes[0]
        eaten += 1

        if eaten == bs:  # 자신의 크기와 같은 수의 물고기를 먹을 때
            bs += 1
            eaten = 0

        arr[f_r][f_c] = 0
        help_time += f_d
        pos = (f_r, f_c)
    return help_time


n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

start = next(((r, c) for r, row in enumerate(arr) for c, val in enumerate(row) if val == BABY_SHARK))
arr[start[0]][start[1]] = 0

print(bfs(arr, start))