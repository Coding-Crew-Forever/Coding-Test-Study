# 의상
# lv 2
# 수학, 딕셔너리, dictionary

def solution(clothes):
    answer = 1
    dictionary = {}
    
    for _, ctype in clothes:
        if ctype not in dictionary.keys():
            dictionary[ctype] = 1
        else:
            dictionary[ctype] += 1
    
    for value in dictionary.values():
        answer *= (value + 1)
    
    # answer = functools.reduce(lambda x, y : x*(y + 1), dictionary.values(), 1)

    return answer - 1