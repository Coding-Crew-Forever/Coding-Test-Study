# 프로그래머스
# Lv1 덧칠하기

def solution(n, m, section):
    answer = 0
    end = 0
    
    for start in section:
        if start > end:
            answer += 1
            end = start + m - 1
        
    return answer
