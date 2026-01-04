# 백준
# 9655. 돌 게임

N = int(input())

dp = [0] * (1000+1)

dp[1] = 1 # SK
dp[2] = 2 # CY
dp[3] = 1 # SK

for i in range(4, N+1):
    dp[i] = min(dp[i-1], dp[i-3]) + 1

if dp[N] % 2 == 1:
    print('SK')
else:
    print('CY')

