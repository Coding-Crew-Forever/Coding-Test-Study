from math import gcd

def solution(arr):
    temp = arr[0]
    
    # 앞에서부터 두개씩 묶어 최소공배수를 구함 (누적)
    for i in arr:
        temp = temp * i // gcd(temp, i)
    
    return temp
