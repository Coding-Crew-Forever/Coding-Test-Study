# 백준
# 실버2 예산

import sys

N = int(sys.stdin.readline()) # 지방의 수
arr = list(map(int, sys.stdin.readline().split())) # 각 지방의 예산 요청
M = int(sys.stdin.readline()) # 총 예산

result = 0
start, end = 1, max(arr)


while start <= end:
    mid = (start + end) // 2 # 중앙값 계산
    total = 0 # 예산 합
    for i in arr:
        if i > mid:
            total += mid
        else:
            total += i
    
    if total <= M:
        # 중앙값+1 ~ 끝값 다시 찾기
        result = mid
        start = mid + 1
    else:
        # 시작 ~ 중앙값-1 다시 찾기
        end = mid - 1

print(result)
