# 백준
# 실버2 A -> B

a, b = map(int, input().split())
r = 1

while (b != a):
    r += 1
    temp = b
    
    # b의 일의자리수가 1인 경우 -1
    if b%10 == 1:
        b //= 10
    # 짝수인 경우 2로 나누기
    elif b%2 == 0:
        b //= 2
    
    # 두 연산을 수행했음에도 값의 변화가 없는 경우
    # 무한루프이므로 탈출하고 -1 출력
    if temp == b:
        print(-1)
        break
else:
    print(r)
