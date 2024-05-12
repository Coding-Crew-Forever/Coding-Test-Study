# 최솟값 만들기
# lv 2

def solution(A,B):
    answer = 0
    sort_A = sorted(A)
    sort_B = sorted(B, reverse=True)
    
    for a, b in zip(sort_A, sort_B):
        answer += a * b

    return answer