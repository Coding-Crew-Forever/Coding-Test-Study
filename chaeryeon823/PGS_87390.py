# n^2 배열 자르기
# lv 2

def solution(n, left, right):
    answer = []

    for i in range(left, right + 1):
        temp = max(i // n, i % n)
        answer.append(temp + 1)

    return answer