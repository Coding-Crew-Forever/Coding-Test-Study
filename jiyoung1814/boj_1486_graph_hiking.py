import sys
import heapq
INF = float('inf')

moves = [(-1,0),(1,0),(0,-1),(0,1)] # 상하좌우

def char_to_num(ch):
    if 'A' <= ch <= 'Z':
        return ord(ch) - ord('A')
    elif 'a' <= ch <= 'z':
        return ord(ch) - ord('a') + 26

def cal_time(s, e):
    return (abs(s-e) ** 2) + 1

input = sys.stdin.readline

N, M, T, D = map(int, input().split())
# N, M, T, D = 6, 6, 6, 36
# N, M, T, D = 7, 4, 5, 14
# N, M, T, D = 8, 9, 4, 50

def dijkstra(graph, start):

    hiking_time = [[INF] * M for _ in range(N)]
    hiking_time[start[0]][start[1]] = 0

    heap = []  # (weight, r, c)
    heapq.heappush(heap, (0, start[0], start[1]))

    while heap:
        h, r, c = heapq.heappop(heap)

        if h > hiking_time[r][c]:
            continue

        for mr, mc in moves:
            nr, nc = mr + r, mc + c

            if 0 <= nr < N and 0 <= nc < M:

                diff = graph[nr][nc] - graph[r][c]

                if abs(diff) <= T:
                    if diff > 0:
                        new_time = h + diff ** 2
                    else:
                        new_time = h + 1
                    # print()

                    if new_time < hiking_time[nr][nc]:
                        hiking_time[nr][nc] = new_time
                        heapq.heappush(heap, (new_time, nr, nc))
                        # print()

    return hiking_time


mountain = [list(map(char_to_num, input().strip())) for _ in range(N)]
# mountain = [[0, 0, 1, 2, 3, 4], [6, 9, 8, 7, 6, 5], [12, 10, 11, 12, 13, 14], [18, 19, 18, 17, 16, 15], [24, 20, 21, 22, 23, 24], [30, 29, 28, 27, 26, 25]]
# mountain = [[1, 2, 3, 4], [0, 9, 10, 5], [0, 8, 7, 6], [0, 0, 0, 0], [0, 14, 12, 10], [0, 16, 18, 8], [0, 2, 4, 6]]
# mountain = [[19, 17, 17, 21, 20, 23, 30, 31, 36], [27, 18, 13, 12, 14, 22, 28, 31, 31], [27, 17, 15, 13, 13, 16, 25, 34, 41], [23, 18, 17, 20, 19, 21, 28, 31, 35], [22, 27, 25, 16, 15, 23, 25, 27, 21], [23, 29, 24, 18, 17, 22, 21, 14, 15], [31, 30, 30, 29, 21, 21, 28, 25, 17], [23, 33, 31, 29, 25, 25, 30, 31, 32]]

hiking_times = dijkstra(mountain, (0,0))

candi = []
for i in range(N):
    for j in range(M):
        if hiking_times[i][j] < D:
            m_height = -1 * mountain[i][j]
            heapq.heappush(candi, (m_height, i, j))


while candi:
    h, r, c = heapq.heappop(candi)
    return_times = dijkstra(mountain, (r, c))

    if hiking_times[r][c] + return_times[0][0] <= D:
        print(mountain[r][c])
        break
