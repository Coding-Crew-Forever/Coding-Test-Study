# 문자열 폭발
# g4

import sys

s = sys.stdin.readline().rstrip()
boom = sys.stdin.readline().rstrip()

stack = []

for i in range(len(s)):
    stack.append(s[i])
    if ''.join(stack[-len(boom):]) == boom:
        for _ in range(len(boom)):
            stack.pop()

if stack:
    print(''.join(stack))
else:
    print('FRULA')