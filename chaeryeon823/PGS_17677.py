# [1차] 뉴스 클러스터링
# lv 2
# 문자열, 구현, 집합

def divide_str(str):
    arr = []
    for i in range(len(str) - 1):
        if str[i].isalpha() and str[i + 1].isalpha():
            arr.append(str[i] + str[i + 1])
        else:
            continue
    return arr

def solution(str1, str2):
    str1_arr = divide_str(str1.lower())
    str2_arr = divide_str(str2.lower())
    intersection = 0
    union = 0
    check = [0] * len(str2_arr)
    
    if len(str1_arr) == 0 and len(str2_arr) == 0:
        return 1 * 65536
    
    
    for i in range(len(str1_arr)):
        for j in range(len(str2_arr)):
            if str1_arr[i] == str2_arr[j] and check[j] == 0:
                check[j] = 1
                intersection += 1
                break
    
    union = (len(str1_arr) + len(str2_arr)) - intersection
    
    return int((intersection / union) * 65536) 


print(solution(	"FRANCE", "french"))