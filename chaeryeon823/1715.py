# 카드 정렬하기
# 우선순위 큐

import sys
import heapq

n = int(sys.stdin.readline().rstrip())
cards = []
for i in range(n):
  cards.append(int(sys.stdin.readline().rstrip()))

heapq.heapify(cards)

answer = 0

while len(cards) > 1:
  sum = heapq.heappop(cards) + heapq.heappop(cards)
  heapq.heappush(cards, sum)
  answer = answer + sum

print(answer)