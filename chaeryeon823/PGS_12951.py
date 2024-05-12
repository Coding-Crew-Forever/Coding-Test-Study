# JadenCase 문자열 만들기
# lv 2

def solution(s):
    answer = ''
    first = True
    for c in s:
        if c == " ":
            answer += c
            first = True
            continue

        if first:
            if c.isalpha() and c.lower():
                answer += c.upper()
            else:
                answer += c
            first = False
            
        else:
            if c.isupper():
                answer += c.lower()
            else:
                answer += c       
    return answer

print(solution("apple    Bannana="))