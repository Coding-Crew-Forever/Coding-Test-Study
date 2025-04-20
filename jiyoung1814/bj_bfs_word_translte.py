from collections import deque

def bfs(begin, target, words):
    queue = deque()
    queue.append([begin, 0])

    while queue:
        now, step = queue.popleft()

        if target == now:
            return step

        for word in words:
            count = 0

            for i in range(len(now)):
                if now[i] != word[i]:
                    count += 1

            if count == 1:
                queue.append([word, step+1])






def solution(begin, target, words):
    answer = 0

    if target not in words:
        return 0

    return bfs(begin, target, words)







print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))