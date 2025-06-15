import sys

input = sys.stdin.readline

n, total = map(int, input().split())
money = [int(input()) for _ in range(n)]
money.sort(reverse=True)

coin = 0
for m in money:
    if total == 0:
        break
    coin += total // m
    total %= m


print(coin)