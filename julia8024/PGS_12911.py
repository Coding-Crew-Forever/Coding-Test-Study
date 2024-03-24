def solution(n):
    bin_n = bin(n).count("1") # 2진수 n의 1의 개수

    while True:
        n += 1
        if bin(n).count("1") == bin_n:
            break
    
    return n
