def solution(number, k):
    stack = []
    
    for val in number:
        if len(stack) == 0:
            stack.append(val)
            continue
        if k > 0:
            while stack[-1] < val:
                stack.pop()
                k -= 1
                if len(stack) == 0 or k <= 0:
                    break
        stack.append(val)
        
    return "".join(stack[:-k] if k > 0 else stack)
