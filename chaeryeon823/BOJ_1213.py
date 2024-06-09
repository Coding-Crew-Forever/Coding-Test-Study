# 펠린드롬
# s3
# counter, 문자열

import sys
from collections import Counter
s = sys.stdin.readline().rstrip()
c = Counter(s)
answer = ''
cnt = 0
arr = list(c.items())
arr.sort(key = lambda x: x[0])
mid = ''
for item in arr:
    if item[1] % 2 != 0:
        cnt += 1
        mid = item[0]
        if cnt == 2:
            print("I'm Sorry Hansoo")
            exit()

for item in arr:
    answer += item[0] * (item[1] // 2)

print(answer + mid + answer[::-1])