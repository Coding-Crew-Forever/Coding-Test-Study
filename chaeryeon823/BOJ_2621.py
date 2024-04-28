# 카드게임
# S3

import sys
from collections import Counter 

def all_different_num(num):
  return len(set(num)) == len(num)

def continuous_num(num):
  for i in range(5):
    if (num[i] + 1) not in num or (num[i] - 1) not in num:
      return False
    return True

def same_color(col):
  return len(set(col)) == 1

def sort_dict(c):
  return sorted(dict(c).items(), key=lambda x:x[1], reverse=True)

color = []
number = []

for i in range(5):
  tmp = sys.stdin.readline().split()
  color.append(tmp[0])
  number.append(int(tmp[1]))

if all_different_num(number):
  if continuous_num(number):
    if same_color(color):
      # 1
      print(max(number) + 900)
    else:
      # 5
      print(max(number) + 500)
  else:
    if same_color(color):
      # 4
      print(max(number) + 600)
    else:
      # 9
      print(max(number) + 100)
else:
  c = Counter(number)
  cnt = dict(c).values()

  if 4 in cnt:
    # 2
    print(c.most_common(n=1)[0][0] + 800)
  else:
    t = sort_dict(c)
    if 3 in cnt:
      if 2 in cnt:
        # 3
        print((t[0][0] * 10) + t[1][0] + 700)
      else:
        # 6
        print((t[0][0] + 400))
    else:
      if len(cnt) == 3:
        # 7
        max_num = max(t[0][0], t[1][0])
        min_num = min(t[0][0], t[1][0])
        print((max_num * 10) + min_num + 300)
      else:
        # 8
        print(c.most_common(n=1)[0][0] + 200)
  