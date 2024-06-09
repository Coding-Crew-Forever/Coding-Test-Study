from collections import Counter

def solution(topping):
    answer = 0
    
    old = Counter(topping)
    young = {}
    
    for i in topping:
        # 딕셔너리 크기가 같으면 동일한 크기로 나눈 것
        if len(old) == len(young):
            answer += 1
        
        # 동생이 해당 토핑을 가지고 있지 않은 경우
        if i not in young:
            # 동생꺼에 토핑 추가
            young[i] = 1
        
        # 철수꺼에서 해당 토핑 1개 제거
        old[i] -= 1
        
        # 해당 토핑을 아예 가지고 있지 않게된 경우 제거
        if old[i] == 0:
            del old[i]
    
    return answer
