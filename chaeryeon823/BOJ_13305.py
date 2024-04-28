# 주유소

import sys 

city = int(sys.stdin.readline().rstrip())
miters = list(map(int, sys.stdin.readline().split()))
prices = list(map(int, sys.stdin.readline().split()))

answer = 0
min_price = prices[0]

for i in range(len(prices)-1):
  if min_price > prices[i]:
    min_price = prices[i]
  answer += min_price * miters[i]
  
print(answer)