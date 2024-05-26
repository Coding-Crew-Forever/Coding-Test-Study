# 튜플
# lv 2
# 문자열

def solution(s):
    answer = []
    s = s.split('{')
    s_list = []
    for i in s:
        if '}' in i:
            tmp = i[:-1].replace('}', '')
            tmp = tmp.split(',')
            tmp = list(map(int, tmp))
            s_list.append(tmp)
    
    s_list = sorted(s_list, key = len)
    
    for nums in s_list:
        for n in nums:
            if n not in answer:
                answer.append(n)
    return answer