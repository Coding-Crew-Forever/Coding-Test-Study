# 백준
# 실버2 나무 자르기 (pypy3로 제출)


n, m = map(int, input().split())
tree = list(map(int, input().split()))

start = 0
end = max(tree)

result = 0

while (start <= end):
    total = 0
    mid = (start + end) // 2
    for i in tree:
        if i > mid:
            total += i - mid
    
    if total < m:
        end = mid - 1
    else:
        result = mid
        start = mid + 1

print(result)
