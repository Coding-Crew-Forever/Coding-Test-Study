# 카드 합체 놀이

import sys, heapq

answer = 0
n, m = map(int, sys.stdin.readline().split())
cards = list(map(int, sys.stdin.readline().split()))


heapq.heapify(cards)

for i in range(m):
  plus = heapq.heappop(cards) + heapq.heappop(cards)
  heapq.heappush(cards, plus)
  heapq.heappush(cards, plus)

print(sum(cards))