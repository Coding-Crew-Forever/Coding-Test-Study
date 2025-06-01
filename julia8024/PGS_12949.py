# 프로그래머스
# Lv2 행렬의 곱셈

def solution(arr1, arr2):
    return [[sum(i*j for i, j in zip(arr1_row,arr2_col)) for arr2_col in zip(*arr2)] for arr1_row in arr1]
