# import sys
# sys.setrecursionlimit(10**6)
#
# def find_parent(parent, x):
#     if parent[x] != x:
#         parent[x] = find_parent(parent, parent[x])
#     return parent[x]
#
# def union(parent, a, b):
#     a = find_parent(parent, a)
#     b = find_parent(parent, b)
#
#     if a < b:
#         parent[b] = a
#     else:
#         parent[a] = b
#
#
# city_num = int(sys.stdin.readline())
# bus_num = int(sys.stdin.readline())
#
#
# edges = []
# parent = [i for i in range(city_num+1)]
#
# for bus in range(bus_num):
#     a, b, cost = map(int, sys.stdin.readline().split())
#     edges.append((cost, a, b))
#
# edges.sort()
#
#
# for edge in edges:
#     cost, a, b = edge
#     if find_parent(parent, a) != find_parent(parent, b):
#         union(parent, a, b)
#
#
# start, end = map(int, sys.stdin.readline().split())
#
#
# min_cost = 0
# now_city = start
#
# while True:
#     edge = next((edge for edge in edges if edge[1] == now_city), None)
#
#     if edge is None:
#         break
#
#     cost, a, b = edge
#
#     min_cost += cost
#     now_city = b
#
#     if now_city == end:
#         break
#
# print(min_cost)

import sys
import heapq

INF = float('inf')

def dijkstra(start, end, n, adj_list):
    dist = [INF] * (n+1)
    dist[start] = 0

    pq = []
    heapq.heappush(pq, (0, start))  # (비용, 도시)

    while pq:
        now_cost, now_node = heapq.heappop(pq)

        if now_cost > dist[now_node]: # 현재 비용이 큐에 있는 비용보다 작을 때만 갱신
            continue

        for new_node, new_cost in adj_list[now_node]:
           new_cost = now_cost + new_cost

           if new_cost < dist[new_node]:
                dist[new_node] = new_cost
                heapq.heappush(pq, (new_cost, new_node))

    return dist[end]


city_num = int(sys.stdin.readline())
bus_num = int(sys.stdin.readline())

adj_list = {i: [] for i in range(1, city_num + 1)}

for _ in range(bus_num):
    a, b, cost = map(int, sys.stdin.readline().split())
    adj_list[a].append((b, cost))

start, end = map(int, sys.stdin.readline().split())
# city_num = 5
# bus_num = 8
# adj_list = {i: [] for i in range(1, city_num+1)}
# edges = [
#     (1, 2, 2),
#     (1, 3, 3),
#     (1, 4, 1),
#     (1, 5, 10),
#     (2, 4, 2),
#     (3, 4, 1),
#     (3, 5, 1),
#     (4, 5, 3),
# ]
# start = 1
# end = 5

result = dijkstra(start, end, city_num, adj_list)
print(result)