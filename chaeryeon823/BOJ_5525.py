# IOIOI
# s1

import sys


N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())
S = sys.stdin.readline().rstrip()

answer = 0
i = 0
cnt = 0

while i < M:
    tmp = S[i:i+3]
    if tmp == 'IOI':
        i += 2
        cnt += 1
        if cnt == N:
            answer += 1
            cnt -= 1
    else:
        i += 1
        cnt = 0

print(answer)

# 좀더 직관적으로 생각하자
# TODO: 다시풀기