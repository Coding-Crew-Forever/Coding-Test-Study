# 이진 변환 반복하기
# lv 2

import math

def solution(s):
    cnt = 0
    zero = 0
    
    while s != "1":
        cnt += 1
        # 0 제거
        if '0' in s:
            zero += s.count('0')
            s = s.replace('0', '')
        
        # 0 제거 후 길이로 이진 변환
        s = bin(len(s))[2:]    

    return [cnt, zero]