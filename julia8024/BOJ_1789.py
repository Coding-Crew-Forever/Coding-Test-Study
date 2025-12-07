# 백준
# 1789. 수들의 합

S = int(input())

cnt = 0 # N
sum = 0

for i in range(1, S+1):
    sum += i
    cnt = i
    if S < sum:
        cnt -= 1
        break

print(cnt)
