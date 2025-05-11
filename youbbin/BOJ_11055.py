N = int(input())
A = list(map(int, input().split()))

dp = A[:]

# 다이나믹 프로그래밍
for i in range(N):
    for j in range(i):
        if A[j] < A[i]:
            dp[i] = max(dp[i], dp[j] + A[i])

print(max(dp))