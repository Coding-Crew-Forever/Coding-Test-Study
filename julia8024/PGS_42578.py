from collections import Counter
import math


def solution(clothes):
    answer = 0
    arr = list(Counter([x for clothes, x in clothes]).values())
    return math.prod([i+1 for i in arr]) - 1

# Counter({'headgear': 2, 'eyewear': 1}) -> [2, 1]
# 해당 요소를 선택하지 않을수도 있음 -> (2+1) * (1+1)
# 아무것도 선택하지 않은 경우를 제외 -> -1
