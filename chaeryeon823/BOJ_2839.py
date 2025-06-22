# 설탕배달
# S4

import sys

n = int(sys.stdin.readline())
result = 0;
while(True):
  if(n % 5 == 0):
    result += n/5;
    print(int(result));
    break;
  else:
    n-=3;
    result+=1;
  if(n < 0):
    print("-1")
    break;
  