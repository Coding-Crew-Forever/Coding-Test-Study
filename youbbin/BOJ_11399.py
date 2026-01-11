import sys

n = int(sys.stdin.readline())
p = list(map(int, sys.stdin.readline().split()))

p.sort() # 오름차순

total = 0
withdraw = 0

for time in p:
    withdraw += time  # 한 사람당 인출시간
    total += withdraw # 총합

# 4. 결과 출력
print(total)