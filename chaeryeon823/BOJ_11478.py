# 서로 다른 부분 문자열의 개수
# s3
# 문자열

import sys
s = sys.stdin.readline().rstrip()
arr = []

for i in range(len(s) - 1):
  for j in range(len(s) - i):
    arr.append(s[j:j+i+1])

print(len(set(arr)) + 1)
