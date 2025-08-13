import sys

input = sys.stdin.readline

move = [(0,1),(1,0)] # 오른쪽, 아래
state = False

def dfs(graph, start):
    stack = [start]
    visited = set()
    N = len(graph)

    while stack:
        r, c= stack.pop()
        num = graph[r][c]
        visited.add((r, c))

        if num == -1:
            return True

        for x, y in move:
            n_r, n_c = r + x * num, c + y * num

            if 0 <= n_r < N and 0 <= n_c < N and (n_r,n_c) not in visited:
                stack.append((n_r,n_c))
    return False


n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]


state = dfs(arr, (0,0))

if state:
    print("HaruHaru")
else:
  print("Hing")