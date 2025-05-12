n = int(input())

points = [] # 좌표 리스트

for i in range(n):
    x, y = map(int, input().split()) # 좌표 입력
    points.append((x, y)) # 리스트에 저장


points.sort(key=lambda point: (point[1], point[0])) # 정렬

for x, y in points:
    print(x, y)