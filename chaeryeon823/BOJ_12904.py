# A와 B
# g5

import sys
S = sys.stdin.readline().rstrip()
T = sys.stdin.readline().rstrip()
answer = -1

while len(S) < len(T):
    if T[-1] == 'A':
        T = T[:-1]
    elif T[-1] == 'B':
        T = T[:-1]
        T = T[::-1]


if S == T:
    answer = 1
else:
    answer = 0


print(answer)


# 문제를 잘 읽자.