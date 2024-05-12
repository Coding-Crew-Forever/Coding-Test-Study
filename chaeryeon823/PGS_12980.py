# 점프와 순간 이동
# lv 2

def solution(n):
    answer = 1
    while n != 1:
        if n % 2 == 0:
            n /= 2
        else:
            n -= 1
            answer += 1

    return answer