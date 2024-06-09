# 카펫
# lv 2

def solution(brown, yellow):
    answer = []
    y_arr = []
    
    # yellow의 가능성 구하기
    for i in range(1, int(yellow**(1/2)) + 1):
        a, b = 0, 0
        if yellow % i == 0:
            a = yellow // i
            b = i
        y_arr.append([a, b])
    
    # brown의 크기 구하고, 그게 주어진 brown 크기와 맞는지 확인
    for y_row, y_col in y_arr:
        b_row = y_row + 2
        b_col = y_col + 2
        
        if (b_row * b_col) - yellow == brown:
            answer = [b_row, b_col]
            break
            
    return answer