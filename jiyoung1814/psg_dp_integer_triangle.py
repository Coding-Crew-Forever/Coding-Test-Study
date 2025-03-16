def solution(triangle):
    n = len(triangle)
    dp = [[-1] * n for _ in range(n)]

    def dfs(i, j):

        if i >= n or j >= len(triangle[i]):
            return 0

        if dp[i][j] != -1:
            return dp[i][j]

        dp[i][j] = triangle[i][j] + max(dfs(i + 1, j), dfs(i + 1, j + 1))
        return dp[i][j]

    return dfs(0, 0)

triangle = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
print(solution(triangle))