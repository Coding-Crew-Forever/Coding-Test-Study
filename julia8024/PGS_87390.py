# 프로그래머스
# Lv2 n^2 배열 자르기

def solution(n, left, right):
    answer = []
    for i in range(left, right + 1):
        a = i//n # 몫
        b = i%n # 나머지
        # 무조건 a가 크도록
        if a < b:
            a, b = b, a
        answer.append(a+1)
    return answer
