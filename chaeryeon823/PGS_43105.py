# 정수 삼각형
# lv 3
# DP
# 아래서 위로 올라가면서 합이 큰 수 더해주기

def solution(triangle):
    for i in range(len(triangle) - 2, -1, -1):
        for j in range(len(triangle[i])):
            triangle[i][j] += max(triangle[i + 1][j], triangle[i + 1][j + 1])
    return triangle[0][0]
