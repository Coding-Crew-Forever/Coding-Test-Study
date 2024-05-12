# 가장 큰 수
# lv2

def solution(numbers):
    answer = ''
    arr = list(map(str, numbers))
    arr = sorted(arr, key = lambda x : x*3, reverse=True)
    answer = ''.join(arr)
    return str(int(answer))

print(solution([39, 3, 30]))