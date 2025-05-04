# 프로그래머스
# Lv2 주식가격

from collections import deque

def solution(prices):
    queue = deque(prices)
    answer = []
    
    while queue:
        price = queue.popleft()
        sec = 0
        
        for q in queue:
            sec += 1
            if price > q:
                break
        answer.append(sec)
    
    return answer
