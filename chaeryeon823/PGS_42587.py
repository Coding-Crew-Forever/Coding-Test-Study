# 프로세스
# lv 2
# 큐, queue

from collections import deque

def solution(priorities, location):
    answer = 0
    q = deque()
    
    for i in range(len(priorities)):
        q.append([i, priorities[i]])
    
    while q:
        tmp = q.popleft()
        if tmp[1] == max(priorities):
            if tmp[0] == location:
                break
            else:
                answer += 1
                priorities.remove(tmp[1])
        else:
            q.append(tmp)
            
                
    return answer + 1