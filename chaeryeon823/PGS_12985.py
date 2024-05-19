# import math

# def solution(n,a,b):
#     answer = 1
#     if b < a:
#         a, b = b, a
    
#     while a != 1 and b != 2:
#         a = math.ceil(a / 2)
#         b = math.ceil(b / 2)
#         answer += 1
    
#     return answer

import math

def solution(n,a,b):
    answer = math.log2(n)
    if a > b:
        a, b = b, a
        
    m = n // 2
    bottom = 1
    top = n
    
    while True:
        if a <= m and b <= m:
            top = m
            m = m // 2
            answer -= 1
        elif a > m and b > m:
            bottom = m + 1
            m = (bottom + top) // 2
            answer -= 1
        else:
            break
    
    return answer
            

print(solution(16, 9, 12))