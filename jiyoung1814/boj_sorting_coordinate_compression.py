import sys

n = int(sys.stdin.readline())
x = list(map(int, sys.stdin.readline().strip().split()))


x_sorted = sorted(list(set(x)))

coordinate = {}
for i in range(len(x_sorted)):
    coordinate[x_sorted[i]] = i

for key in x:
    print(coordinate[key], end=' ')