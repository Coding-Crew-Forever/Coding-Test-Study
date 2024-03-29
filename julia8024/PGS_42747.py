
def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    
    # a번 이상 인용된 논문이 b편 이상 -> a, b 중 작은 값이 H-index
    for i in range(len(citations)):
        tmp = citations[i] if citations[i] < i+1 else i+1
        # 방금 탐색한 H-index가 이전에 탐색한 H-index보다 큰 경우 방금 탐색한 값으로 변경
        answer = tmp if tmp > answer else answer
    
    return answer
