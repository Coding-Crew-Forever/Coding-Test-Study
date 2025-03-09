# 프로그래머스
# Lv3 N으로 표현

def solution(N, number):
    if N == number:
        return 1
    
    answer = 0
    s = [set() for i in range(8)]
    
    # 각 set마다 기본 수 "N" * i 값으로 초기화
    for i, x in enumerate(s, start=1):
        x.add(int(str(N) * i))
    
    for i in range(1, 8):
        for j in range(i):
            for op1 in s[j]:
                for op2 in s[i-j-1]:
                    s[i].add(op1 + op2)
                    s[i].add(op1 - op2)
                    s[i].add(op1 * op2)
                    if op2 != 0:
                        s[i].add(op1 // op2)
    
        if number in s[i]:
            answer = i+1
            break
    else:
        return -1
        
    return answer
