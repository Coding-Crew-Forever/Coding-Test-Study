def solution(arr1, arr2):
    n = len(arr1)
    m = len(arr2[0])
    k = len(arr2)
   
    answer = [[0] * m for _ in range(n)]

    # 행렬 곱셈
    for i in range(n):         # arr1의 행
        for j in range(m):     # arr2의 열
            for t in range(k): # 곱셈
                answer[i][j] += arr1[i][t] * arr2[t][j]

    return answer
