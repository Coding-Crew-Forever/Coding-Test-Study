import sys

n = int(sys.stdin.readline())
p = list(map(int, sys.stdin.readline().split()))

p.sort()

time = 0
for i, t in enumerate(p):
    time += t
    if i == 0:continue

    time += sum(p[:i])

print(time)
