import sys
input = sys.stdin.readline

n = int(input())

arr= []
for _ in range(n):
    age, name = input().split()
    arr.append([int(age),name])

sorted_arr = sorted(arr, key = lambda x: x[0])

for value in sorted_arr:
    print(value[0], value[1])
