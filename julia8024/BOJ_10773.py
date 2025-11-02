# 백준
# 실버4 제로

import sys

K = int(sys.stdin.readline())
nums = []

for i in range(K):
    temp = int(sys.stdin.readline())
    if temp == 0:
        nums.pop()
    else:
        nums.append(temp)

print(sum(nums))
