def solution(n, lost, reserve):
    lost_set = set(lost)
    reserve_set = set(reserve)

    # 여벌이 있지만 도난당한 경우 제거
    intersect = lost_set & reserve_set
    lost_set -= intersect
    reserve_set -= intersect

    for student in sorted(lost_set):
        if student - 1 in reserve_set:
            reserve_set.remove(student - 1)
        elif student + 1 in reserve_set:
            reserve_set.remove(student + 1)
        else:
            continue
        lost_set.remove(student)

    return n - len(lost_set)
