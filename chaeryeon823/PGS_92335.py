# k진수에서 소수 개수 구하기
# lv 2

import math

# 진수 변환
def jinsoo(n, q):
    rev_base = ''

    while n > 0:
        n, mod = divmod(n, q)
        rev_base += str(mod)

    return rev_base[::-1] 

# 소수 판별 함수
def is_prime_number(x):
    if x == 1:
        return 0
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return 0
    return 1

def solution(n, k):
    answer = 0
    if k != 10:
        change_n = jinsoo(n, k)
    else:
        change_n = str(n)

    if '0' not in change_n:
        return is_prime_number(int(change_n))
    
    arr = change_n.split('0')
    
    for a in arr:
        if a:
            answer += is_prime_number(int(a))
            
    return answer

print(solution(3, 10))