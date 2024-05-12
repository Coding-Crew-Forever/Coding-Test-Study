# 피보나치 수
# lv 2

def solution(n):
    answer = 0
    if n == 0:
        return 0
    if n == 1 or n == 2:
        return 1
    
    a, b = 1, 1
    
    for i in range(1, n):
        a, b = b, a+b
    
    return a % 1234567