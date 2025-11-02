import math


def solution(arr):
    # a, b의 최소공배수
    def lcm(a, b):
        return (a * b) // math.gcd(a, b)

    result = arr[0]

    for i in range(1, len(arr)):
        result = lcm(result, arr[i])

    return result

