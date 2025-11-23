import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    nums1 = set(map(int, input().split()))
    m = int(input())
    nums2 = list(map(int, input().split()))

    for num in nums2:
        print(1 if num in nums1 else 0)
