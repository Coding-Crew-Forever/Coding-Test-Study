s = int(input())

cnt = 0
n = 0
while cnt + (n + 1) <= s:
    n += 1
    cnt += n


print(n)