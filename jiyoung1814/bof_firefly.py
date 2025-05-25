import sys

n, h = map(int, sys.stdin.readline().split())

down = [0] * (h + 1)
up = [0] * (h + 1)

for i in range(n):
    length = int(sys.stdin.readline())
    if i % 2 == 0:
        down[length] += 1
    else:
        up[length] += 1

for i in range(h - 1, 0, -1):
    down[i] += down[i + 1]
    up[i] += up[i + 1]

for i in range(1, h + 1):

    if min_count > (down[i] + up[h - i + 1]):
        min_count = (down[i] + up[h - i + 1])
        range_count = 1
    elif min_count == (down[i] + up[h - i + 1]):
        range_count += 1

print(min_count, range_count)

