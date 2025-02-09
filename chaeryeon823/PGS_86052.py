# 빛의 경로 사이클
# lv 2
# dfs
# https://school.programmers.co.kr/learn/courses/30/lessons/86052?language=python3

def solution(grid):
    row = len(grid)
    col = len(grid[0]) 

    visits = [[[False for _ in range(4)] for _ in range(col)] for _ in range(row)]

    directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

    def dfs(r, c, d):
        path_length = 0
        while not visits[r][c][d]:
            visits[r][c][d] = True
            path_length += 1

            if grid[r][c] == 'L':
                d = (d - 1) % 4
            elif grid[r][c] == 'R':
                d = (d + 1) % 4

            r = (r + directions[d][0]) % row
            c = (c + directions[d][1]) % col

        return path_length

    answer = []
    for r in range(row):
        for c in range(col):
            for d in range(4):
                if not visits[r][c][d]:
                    cycle_length = dfs(r, c, d)
                    if cycle_length > 0:
                        answer.append(cycle_length)

    return sorted(answer)
