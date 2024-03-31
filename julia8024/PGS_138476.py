from collections import Counter

def solution(k, tangerine):
    answer = 0
    
    # 크기별 갯수 -> 갯수가 많은 순서대로 정렬
    # 갯수가 많은 것부터 고르기
    for i in sorted(list(Counter(tangerine).values()), reverse=True):
        k -= i
        answer += 1
        if k <= 0:
            break
    
    return answer
