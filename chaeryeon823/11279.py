# 최대힙

import heapq, sys

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
    heapq.heappush(data, (-tmp, tmp))