# 최소힙
import heapq
import sys

n = int(sys.stdin.readline().rstrip())
data = []



for i in range(n):
  tmp = int(sys.stdin.readline().rstrip())
  if tmp == 0:
    if len(data) != 0:
      print(heapq.heappop(data))
    
    else:
      print(0)

  else:
    heapq.heappush(data, tmp)



