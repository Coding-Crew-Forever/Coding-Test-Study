import sys

input = sys.stdin.readline
N = int(input().strip())
req = list(map(int, input().split()))
M = int(input().strip())

# 모든 요청 다 줄 수 있을 때
if sum(req) <= M:
    print(max(req))
    sys.exit(0)

# 아닐 때 이분 탐색
lo, hi = 0, max(req)
ans = 0
while lo <= hi:
    mid = (lo + hi) // 2
    total = 0
    for x in req:
        total += x if x <= mid else mid

    if total <= M:
        ans = mid
        lo = mid + 1
    else:
        hi = mid - 1

print(ans)
