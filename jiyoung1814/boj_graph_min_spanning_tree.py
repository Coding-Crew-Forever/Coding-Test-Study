import sys
sys.setrecursionlimit(10**6)

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


v_num, e_num = map(int, sys.stdin.readline().split())
parent = [i for i in range(v_num + 1)]

edges = []

for e in range(e_num):
    a, b, cost = map(int, sys.stdin.readline().split())
    edges.append((cost, a, b))

edges.sort()


weight = 0

for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union(parent, a, b)
        weight += cost

print(weight)