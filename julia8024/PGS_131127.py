from collections import Counter

def solution(want, number, discount):
    answer = 0
    
    # {"banana" : 3, "apple" : 2,...} 형태의 딕셔너리 구조로 변경
    dicts = {x:y for x, y in zip(want, number)}
    
    # 열흘간의 상품 종류&수량이 원하는 상품 종류&수량과 일치하는 경우 +1
    for i in range(len(discount)):
        if dicts == Counter(discount[i:i+10]):
            answer += 1
    
    return answer
