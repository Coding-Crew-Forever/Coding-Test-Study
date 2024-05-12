# 다음 큰 숫자
# lv 2

def solution(n):
    answer = 0
    tmp = n
    while answer == 0:
        tmp += 1
        if str(bin(n)).count('1') == str(bin(tmp)).count('1'):
            answer = tmp
    return answer