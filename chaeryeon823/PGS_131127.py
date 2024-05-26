# 할인 행사
# lv 2
# Counter 카운터

from collections import Counter

def check(dict_want_number, dis):
    counter_dis = Counter(dis)
    return counter_dis == dict_want_number

def solution(want, number, discount):
    answer = 0
    dic = {}
    
    for i in range(len(want)):
        dic[want[i]] = number[i]
    
    for i in range(len(discount) - 9):
        answer += check(dic, discount[i:i+10])
    
    return answer