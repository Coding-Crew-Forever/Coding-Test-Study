def solution(n, lost, reserve):

    lost_set = set(lost) - set(reserve)
    reserve_set = set(reserve) - set(lost)

    borrowed = []

    for l in sorted(lost_set):
        if l-1 in reserve_set:
            reserve_set.remove(l - 1)
            borrowed.append(l)
        elif l+1 in reserve_set:
            reserve_set.remove(l + 1)
            borrowed.append(l)

    answer = n - (len(lost_set) - len(borrowed))
    print(answer)


    return answer


solution(5, [2,4], [1,3,5])