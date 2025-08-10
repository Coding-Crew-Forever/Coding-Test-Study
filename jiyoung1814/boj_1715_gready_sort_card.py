import sys
import heapq

input = sys.stdin.readline

n = int(input())
cards = [int(input()) for _ in range(n)]

heapq.heapify(cards)
combine_num = 0

while len(cards) > 1:
    min_1 = heapq.heappop(cards)
    min_2 = heapq.heappop(cards)

    merge = min_1 + min_2
    combine_num += merge

    heapq.heappush(cards, merge)

print(combine_num)
