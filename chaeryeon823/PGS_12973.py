# 짝지어 제거하기
# lv 2
def solution(s):
    stack = []
    stack.append(s[0])

    for i in range(1, len(s)):
        if stack:
            if stack[-1] == s[i]:
                stack.pop()
            else:
                stack.append(s[i])
        else:
            stack.append(s[i])           

    if stack:
        return 0
    else:
        return 1
