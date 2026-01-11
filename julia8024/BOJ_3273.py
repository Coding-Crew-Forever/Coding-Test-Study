# 백준
# 3273. 두 수의 합

import sys

n = int(sys.stdin.readline())
a = set(map(int, sys.stdin.readline().split(" ")))
x = int(sys.stdin.readline())
count = 0


for i in a:
    j = x - i
    if j in a:
        count += 1

print(int(count/2))
