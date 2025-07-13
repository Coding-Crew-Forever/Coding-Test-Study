import sys

input = sys.stdin.readline

arr_srt = input()

arr = [int(i) for i in arr_srt[:len(arr_srt)-1]]

sorted = int(''.join(map(str, sorted(arr, reverse=True))))

print(sorted)