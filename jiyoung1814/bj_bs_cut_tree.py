import sys

def binary_search(arr, target, start, end, result = 0):
    if start > end:
        return result

    mid = (start + end) // 2

    left_tree = sum((tree - mid) for tree in arr if tree > mid)

    if left_tree >= target:
        return binary_search(arr, target, mid+1, end, mid)
    elif left_tree < target:
        return binary_search(arr, target, start, mid-1, result)


t_n, t_m = map(int, sys.stdin.readline().split())
t_arr = list(map(int, sys.stdin.readline().split()))

t_arr.sort()

print(binary_search(t_arr, t_m, 0, t_arr[-1]-1))