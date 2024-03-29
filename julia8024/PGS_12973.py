def solution(s):
    
    stack = []
    
    # s 첫문자부터 탐색
    for i in s:
        # 만약 스택이 비어있지 않고,
        # 스택에 가장 마지막에 들어간 문자가 현재 문자와 같으면
        if stack and stack[-1] == i:
            # 스택에서 제거하고 다음 문자로 넘어감
            stack.pop()
            continue
        # 스택이 비어있거나,
        # 스택에 가장 마지막에 들어간 문자가 현재 문자와 다르면
        # 스택에 현재 문자 추가
        stack.append(i)
    
    # 전체 탐색 후 스택이 비어있다면, 모두 짝지어 제거되었다는 의미
    return 0 if stack else 1
