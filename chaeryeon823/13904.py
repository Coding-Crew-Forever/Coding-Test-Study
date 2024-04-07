# 과제
# G3

import sys, heapq

n = int(sys.stdin.readline().rstrip())
tasks = []
timeline = {}

for i in range(n):
  d, w = map(int, sys.stdin.readline().split())
  heapq.heappush(tasks, (-w, d))


for i in range(n):
  task = heapq.heappop(tasks)

  if task[1] not in timeline:
    timeline[task[1]] = -task[0]
  
  else:
    for i in range(task[1]):
      if (task[1] - i) not in timeline:
        timeline[task[1] - i] = -task[0]
        break

  
print(sum(timeline.values()))


