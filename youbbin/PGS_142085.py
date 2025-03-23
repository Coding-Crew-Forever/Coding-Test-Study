def solution(n, k, enemy):
    left, right = 0, len(enemy)

    while left <= right:
        invincible_count = k
        mid = (left + right) // 2
        round_enemies = sorted(enemy[:mid], reverse=True) # 정렬
        sum_damage = 0

        for i in range(len(round_enemies)):
            if invincible_count != 0:  # 무적권이 남아있으면
                invincible_count -= 1  # 무적권 사용
            else:
                sum_damage += round_enemies[i]  # 병사 소모

        if n - sum_damage >= 0 and k >= 1:
            left = mid + 1
        else:
            right = mid - 1

        mid = (left + right) // 2

    answer = left - 1
    return answer