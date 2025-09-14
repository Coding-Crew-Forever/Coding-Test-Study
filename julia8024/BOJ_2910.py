# 백준
# 실버3 빈도 정렬

import sys

N, C = list(map(int, sys.stdin.readline().split()))
arr = list(map(int, sys.stdin.readline().split()))

dic = {}
order = 0 # 출현 순서
result = []

# dic[숫자] = [빈도, 출현순서] 로 저장
for i in arr:
    if i in dic:
        dic[i][0] += 1
    else:
        dic[i] = [1, order]
        order += 1

# 출현빈도(내림차순), 출현순서(오른차순) 순 정렬
sorted_dic = sorted(dic.items(), key = lambda x: (-x[1][0], x[1][1]))

for num, (cnt, _) in sorted_dic:
    result.extend([num] * cnt)

print(*result)
