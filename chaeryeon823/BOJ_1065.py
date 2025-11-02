n = int(input())
answer = 0

if n < 100:
    answer = n
else:
    answer = 99
    for i in range(100, n + 1):
        hun = i // 100
        ten = (i // 10) % 10
        one = i % 10

        if (hun - ten) == (ten - one):
            answer += 1

print(answer)
