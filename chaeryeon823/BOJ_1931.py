import sys

n = int(sys.stdin.readline())

data = [list(map(int, sys.stdin.readline().split())) for i in range(n)]

data.sort(key = lambda x:(x[1], x[0]))

cnt = 1
end_time = data[0][1]
for i in range(1,n):
    if data[i][0] >= end_time :
        cnt += 1
        end_time = data[i][1]

print(cnt)      