from collections import deque

def solution(s):
    answer = 0
    queue = deque(s)
    for _ in range(len(s)): # 왼쪽으로 이동해서 검사를 반복하는 횟수
        if check("".join(queue)): answer += 1
        queue.rotate(-1)
        
    return answer

def check(s): # 쌍 맞는 괄호를 공백으로 대치해서 빈 배열이면 올바른 것
    while True:
        if "()" in s: s = s.replace("()", "")
        elif "{}" in s: s = s.replace("{}", "")
        elif "[]" in s: s = s.replace("[]", "")
        else: return True if len(s) == 0 else False
