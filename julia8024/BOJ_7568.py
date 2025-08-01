# 백준
# 실버5 덩치


count = int(input())
student_list = []

for _ in range(count):
    weight, height = map(int, input().split())
    student_list.append((weight, height))
    
for i in student_list:
    rank = 1
    for j in student_list:
        if i[0] < j[0] and i[1] < j[1]:
            rank += 1
    print(rank, end=" ")
