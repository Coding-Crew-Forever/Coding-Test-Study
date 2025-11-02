# 프로그래머스
# 60058. 괄호 변환

def check_balance(s):
    check = 0
    for i in s:
        if i == '(':
            check += 1
        else:
            check -= 1

    return True if check == 0 else False

def check_correct(s):
    stack = []
    for i in s:
        if i == '(':
            stack.append(i)
        elif i == ')' and len(stack) != 0:
            stack.pop()
        else:
            return False
    return True if len(stack) == 0 else False

def solution(p):
    answer = ''
    u = ""
    v = ""
    
    # 빈 문자열이거나, 올바른 괄호 문자열인 경우
    if len(p) == 0 or check_correct(p):
        return p
    
    # 문자열 나누기 (u가 처음으로 올바른 괄호 문자열이 될때)
    for i in range(2, len(p)+1, 2):
        if check_balance(p[0:i]):
            u = p[:i]
            v = p[i:]
            break
    
    if (check_correct(u)):
        answer += u + solution(v)
    else:
        answer += '(' + solution(v) + ')'
        for i in u[1:-1]:
            if i == '(':
                answer += ')'
            else:
                answer += '('
    
    return answer
