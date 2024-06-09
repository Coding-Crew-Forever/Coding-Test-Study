# 영단어 암기는 괴로워
# s3

import sys
from collections import Counter
n, m = map(int, sys.stdin.readline().rstrip().split())
arr = []
for _ in range(n):
    word = sys.stdin.readline().rstrip()
    if len(word) >= m:
        arr.append(word)


c = list(Counter(arr).items())

c.sort(key=lambda x:(-x[1], -len(x[0]), x[0]))
for a in c:
    print(a[0])