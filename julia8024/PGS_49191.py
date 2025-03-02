# 프로그래머스
# Lv3 순위

from collections import defaultdict

def solution(n, results):
    answer = 0
    
    win = defaultdict(set) # 이긴 선수
    lose = defaultdict(set) # 진 선수
    
    for winner, loser in results:
        win[loser].add(winner)
        lose[winner].add(loser)
    
    for i in range(1, n+1):
        for winner in win[i]:
            lose[winner].update(lose[i])
        for loser in lose[i]:
            win[loser].update(win[i])
    
    for i in range(1, n+1):
        if len(win[i]) + len(lose[i]) == n-1:
            answer += 1
    
    return answer
