from collections import deque

def solution(begin, target, words):
    answer = 0
    q = deque()
    q.append([begin, 0])
    visited = [0] * len(words)
    
    while q:
        word, cnt = q.popleft()
        if word == target:
            return cnt
        for i in range(len(words)):
            tmp = 0
            if not visited[i]:
                for j in range(len(word)):
                    if word[j] != words[i][j]:
                        tmp += 1
            
                if tmp == 1:
                    q.append([words[i], cnt+1])
                    visited[i] = 1
    return 0
