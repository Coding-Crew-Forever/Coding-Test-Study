import sys
import heapq

input = sys.stdin.readline

n = int(input())
classes = [tuple(map(int, input().split())) for _ in range(n)]
classes.sort()

classes_end = []
heapq.heappush(classes_end, classes[0][1])
class_num = 0

for i in range(1, n):

    s, e = classes[i]

    if classes_end[0] <= s:
        heapq.heappop(classes_end)

    heapq.heappush(classes_end, e)

print(len(classes_end))



