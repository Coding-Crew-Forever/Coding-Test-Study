import sys

def bs(start, end, arr, num):
    while start <= end: # 이진탐색
        mid = (start + end) // 2

        if arr[mid] == num:
            return 1
        elif arr[mid] > num:
            end = mid - 1
        elif arr[mid] < num:
            start = mid + 1

input_n = int(sys.stdin.readline())
arr_n = list(map(int, sys.stdin.readline().split()))
arr_n.sort()

input_m = int(sys.stdin.readline())
arr_m = list(map(int, sys.stdin.readline().split()))

start = 0
end = len(arr_n)-1

for m in arr_m:
    if bs(start, end, arr_n, m):
        print(1)
    else:
        print(0)
