# 귤 고르기
# Lv 2

from collections import Counter

def solution(k, tangerine):
    answer = 0
    cnt = sorted(Counter(tangerine).values(), reverse=True)
    tmp = 0
    for c in cnt:
        if tmp < k:
            tmp += c
            answer += 1
        else:
            break
    
    return answer