def solution(d, budget):
    answer = 0
    d = sorted(d) # 정렬
    for i in d:
        if budget == 0: # 예산 다 떨어지면 끝
            return answer
        if i <= budget: # 신청 금액이 예산보다 적으면 지원
            budget -= i
            answer += 1
    return answer