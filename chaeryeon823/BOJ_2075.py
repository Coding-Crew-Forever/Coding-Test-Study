# N번째 큰수

import sys, heapq

n = int(sys.stdin.readline().rstrip())
numbers = []


for i in range(n):
  tmp = map(int, sys.stdin.readline().split())
  for t in tmp:
    if len(numbers) >= n :
      if numbers[0] < t:
        heapq.heappop(numbers)
        heapq.heappush(numbers, t)
    else:
      heapq.heappush(numbers, t)

print(numbers[0])
