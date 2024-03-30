# 절대값 힙

import sys, heapq

n = int(sys.stdin.readline().rstrip())
data = []

for i in range(n):
  tmp = int(sys.stdin.readline().rstrip())
  if tmp == 0:
    if data:
      print(heapq.heappop(data)[1])
    else:
      print(0)
  
  else:
    heapq.heappush(data, (abs(tmp), tmp))
