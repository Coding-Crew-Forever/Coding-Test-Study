# 숫자의 표현
# lv 2

def solution(n):
    answer = 1
    for i in range(1, n):
        total = 0
        tmp = i
        while total < n:
            total += tmp
            tmp += 1
        if total == n:
            answer += 1
            
    return answer

print(solution(15))