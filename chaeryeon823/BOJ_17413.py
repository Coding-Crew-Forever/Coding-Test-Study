# 단어 뒤집기2
# s3
# 문자열

import sys

s = sys.stdin.readline().rstrip() + ' '
tmp = ''
answer = ''
check = False

for c in s:
    if c == '<':
        tmp = tmp[::-1]
        answer += tmp
        tmp = ''
        tmp += c
        check = True
    elif c == '>':
        tmp += c
        answer += tmp
        check = False
        tmp = ''
    elif c == ' ' and check == False:
        tmp = tmp[::-1]
        answer += tmp + ' '
        tmp = ''
    else:
        tmp += c

print(answer.rstrip())



