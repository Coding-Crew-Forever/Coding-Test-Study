import sys,heapq
INF = float('inf')
input = sys.stdin.readline

N, M = map(int, input().split())
# N, M = 6, 7
# N, M = 8, 11

def dijkstra(graph, start, ban = None):
    dist = [INF] * (N+1)
    dist[start] = 0

    heap = [(0, start)]  # weight, start

    while heap:
        w, s = heapq.heappop(heap)

        # if w > dist[s]:  # 기존 방법
        #     continue
        if dist[s] != w: #중복 경로 무시
            continue
        if start == 1 and s == N: # N까지 최단경로 확정 → 조기 종료
            break

        for e, weight in graph[s]:

            if ban is not None and (ban == (s, e) or ban == (e, s)):  # 간선 무시
                continue

            nw = w + weight
            if dist[e] > nw:
                dist[e] = nw

                heapq.heappush(heap, (nw, e))

    return dist

path = [tuple(map(int, input().split())) for _ in range(M)]
# path = [(1, 2, 1), (1, 4, 3), (3, 6, 1), (4, 5, 1), (2, 3, 2), (3, 4, 1), (5, 6, 2)]
# path = [(1, 2, 1), (1, 5, 8), (1, 7, 9), (2, 5, 2), (3, 4, 4), (3, 6, 3), (3, 8, 5), (4, 6, 10), (4, 8, 11), (5, 6, 6), (5, 7, 7)]

graph = [[] for _ in range(N+1)]
for s, e, w in path:
    graph[s].append((e, w))
    graph[e].append((s, w))

start_dist = dijkstra(graph, 1) # 정방향
min_time = start_dist[N]

if min_time == INF:
    print(-1)
    sys.exit(0)

end_dist = dijkstra(graph, N) # 역방향

cands = []
for s, e, w in path:
    if min_time == start_dist[s] + w + end_dist[e]:
        cands.append((s, e))

max_delay_time = 0
for b in cands:
    ban_dist = dijkstra(graph, 1, b)

    ban_min_time = ban_dist[N]

    if ban_min_time == INF:
        max_delay_time = -1
        break

    max_delay_time = max(max_delay_time, (ban_min_time-min_time))


print(max_delay_time)
