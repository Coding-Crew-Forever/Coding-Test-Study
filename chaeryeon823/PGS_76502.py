# 괄호 회전하기
# lv 2

def check_bracket(st):
    cl = [']', ')', '}']
    op = ['[', '(', '{']
    stack = []
    
    for c in st:
        if c == op[0] or c == op[1] or c == op[2]:
            stack.append(c)
        else:
            if len(stack) == 0:
                return False
            else:
                if cl.index(c) == op.index(stack[-1]):
                    stack.pop()
                else:
                    return False
    if len(stack) == 0:
        return True
        
    return False
    

def solution(s):
    answer = 0
    l = len(s)
    for i in range(l):
        tmp = s[i]
        answer += check_bracket(s[i:i+l])
        s = s + tmp
    return answer