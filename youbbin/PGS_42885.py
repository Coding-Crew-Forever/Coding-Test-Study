def solution(people, limit):
    people.sort()
    answer = 0
    a = 0
    b = len(people) - 1

    while a <= b:
        if people[a] + people[b] > limit:
            b -= 1
        else:
            a += 1
            b -= 1
        answer += 1

    return answer