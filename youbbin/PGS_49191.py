def solution(n, results):
    win = [[False] * n for _ in range(n)]

    for a, b in results:
        win[a - 1][b - 1] = True

    for k in range(n):
        for i in range(n):
            if win[i][k]:
                row_i = win[i]
                row_k = win[k]
                for j in range(n):
                    if row_k[j] and not row_i[j]:
                        row_i[j] = True

    answer = 0
    for i in range(n):
        known = 0
        for j in range(n):
            if i == j:
                continue
            if win[i][j] or win[j][i]:
                known += 1
        if known == n - 1:
            answer += 1
    return answer
