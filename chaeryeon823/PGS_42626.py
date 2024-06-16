# 더 맵게
# lv 2
# 최소 힙

import heapq

def solution(scoville, K):
    answer = 0
    hq = []
    for s in scoville:
        heapq.heappush(hq, s)
    
    while len(hq) > 1:
        if hq[0] < K:
            a, b = heapq.heappop(hq), heapq.heappop(hq)
            heapq.heappush(hq, a + (b * 2))
            answer += 1
        else:
            break
    
    if hq[0] < K:
        return -1
    
    return answer