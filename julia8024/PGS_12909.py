def solution(s):
    stack = []
    
    for i in s:
        if i == "(":
            stack.append("(")
        elif i == ")" and len(stack) != 0:
            stack.pop()
        else:
            return False
    return True if len(stack) == 0 else False
