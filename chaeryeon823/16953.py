# A->B
import sys

a, b = map(int, sys.stdin.readline().split())

answer = 1

while b != a:

  temp = b

  if b % 10 == 1:
    b = b // 10
    answer += 1
  elif b % 2 == 0:
    b = b // 2
    answer += 1

  if b == temp:
    answer = -1
    break
 
print(answer)

