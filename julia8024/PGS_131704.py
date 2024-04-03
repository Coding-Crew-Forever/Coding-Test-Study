def solution(order):
    stack, cur, answer = [], 0, 0
    
    for i in range(1, len(order)+1):
        stack.append(i)
        while stack and stack[-1] == order[cur]:
            stack.pop()
            answer += 1
            cur += 1

    return answer
