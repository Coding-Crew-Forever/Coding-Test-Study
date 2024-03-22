def solution(sizes):
    # width > height 만들기
    for i in range(len(sizes)):
        if sizes[i][0] < sizes[i][1]: # width < height?
            sizes[i][0], sizes[i][1] = sizes[i][1], sizes[i][0]
    
    # width의 가장 큰 값, height의 가장 큰 값 서로 곱하기
    width, height = list(zip(*sizes))
    return max(width) * max(height)
