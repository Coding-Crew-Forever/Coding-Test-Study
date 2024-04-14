import sys 

str = sys.stdin.readline().strip()

list = list(str.split("-"))
result = 0

for i in range(len(list)):
    if (list[i].find("+") > 0):
        sum = 0
        for n in list[i].split("+"):
            sum += int(n)
        list[i] = sum
    else:
        list[i] = int(list[i])

result = list[0]
for i in range(1,len(list)):
    result -= list[i]

print(result)