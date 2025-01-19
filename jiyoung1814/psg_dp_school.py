def solution(n, m, puddles):
    dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]

    for r, c in puddles:
        dp[r][c] = -1

    dp[1][1] = 1

    for r in range(1, n + 1):
        for c in range(1, m + 1):
            if dp[r][c] == -1:
                dp[r][c] = 0
                continue

            dp[r][c] += dp[r - 1][c] + dp[r][c - 1] % 1000000007

    return dp[n][m]


if __name__ == '__main__':
    print(solution(3, 4, [[2, 2]]))
