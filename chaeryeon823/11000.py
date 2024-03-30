# 강의실 배정

import sys, heapq

n = int(sys.stdin.readline().rstrip())
time = []
answer = 0
end_time = []

for i in range(n):
  start, end = map(int, sys.stdin.readline().split())
  heapq.heappush(time, (start, end))


for i in range(n):
  tmp = heapq.heappop(time)

  if len(end_time) == 0:
    heapq.heappush(end_time, tmp[1])
    answer += 1
  
  else:
    min_end_time = heapq.heappop(end_time)
    if min_end_time > tmp[0]:
      heapq.heappush(end_time, min_end_time)
      answer += 1
    heapq.heappush(end_time, tmp[1])


print(answer)
