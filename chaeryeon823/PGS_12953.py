# N개의 최소공배수
# lv 2

def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def solution(arr):
    while len(arr) != 1:
        a = arr.pop()
        b = arr.pop()
        
        g = gcd(a, b)
        l = a * b / g
        
        arr.append(l)
        
    return arr[0]