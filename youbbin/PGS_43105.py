def solution(triangle):
    answer = 0
    for i in range(1, len(triangle)):
        for j in range(i + 1):
            if j == 0: # 왼쪽 끝일 경우
                triangle[i][j] += triangle[i - 1][j]
            elif j == i: # 오른쪽 끝일 경우
                triangle[i][j] += triangle[i - 1][j - 1]
            else : # 그 외 중간에 있는 경우
                triangle[i][j] += max(triangle[i - 1][j], triangle[i - 1][j - 1])
    answer = max(triangle[-1])
    return answer