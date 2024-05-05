# 올바른 괄호
# lv 2
def solution(s):
    q = []
    
    for c in s:
        if c == "(":
            q.append("(")
        else:
            if len(q) == 0:
                return False
            else:
                q.pop()
                
    if q:
        return False
        
    return True