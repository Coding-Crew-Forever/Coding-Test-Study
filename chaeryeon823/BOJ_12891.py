# DNA 비밀번호
# s3

import sys
from collections import deque
n, m = map(int, sys.stdin.readline().rstrip().split())
s = sys.stdin.readline().rstrip()

A, C, G, T = map(int, sys.stdin.readline().split())
cnt = {'A':0, 'G':0, 'C':0, 'T':0}
answer = 0
left, right = 0, m - 1

# 첫번째 구간 마지막 하나 빼고
tmp = s[:right]

for t in tmp:
    cnt[t] += 1

# 나머지 구간
while right < n:
    
    # 다음거 추가
    cnt[s[right]] += 1
    right += 1

    # 계산
    if cnt['A'] >= A and cnt['G'] >= G and cnt['C'] >= C and cnt['T'] >= T:
        answer += 1
    
    # 제일 첫번째꺼 빼기
    cnt[s[left]] -= 1
    left += 1
 

print(answer)
