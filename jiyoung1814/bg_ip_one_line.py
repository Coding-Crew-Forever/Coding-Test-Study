import sys


num = int(sys.stdin.readline())
tall = list(map(int, sys.stdin.readline().split()))

answer = [0] * num

for i, t in enumerate(tall):
    cnt = 0
    for j, a in enumerate(answer):
        if cnt < t and a == 0:
            cnt += 1
        elif a == 0 and cnt == t:
            answer[j] = i + 1
            break
print(*answer)

