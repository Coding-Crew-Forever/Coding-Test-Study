# 프로그래머스
# Lv2 광물 캐기

def solution(picks, minerals):
    answer = 0
    pick_sum = sum(i for i in picks) # 전체 곡괭이 수
    
    # 캘 수 있는 광물 수
    min_num = pick_sum * 5
    minerals = minerals[:min_num] if (min_num) < len(minerals) else minerals
    
    # 광물 조사
    new_minerals = [[0,0,0] for _ in range(len(minerals) // 5 + 1)]
    for i in range(len(minerals)):
        if minerals[i] == 'diamond':
            new_minerals[i//5][0] += 1
        elif minerals[i] == 'iron':
            new_minerals[i//5][1] += 1
        elif minerals[i] == 'stone':
            new_minerals[i//5][2] += 1
    
    # 광물의 순서 정렬 : 다이아 > 철 > 돌
    new_minerals.sort(key=lambda x: (-x[0], -x[1], -x[2]))
    
    # 정렬된 광물을 다이아 > 철 > 돌 곡괭이 순서로 캐기
    for i in new_minerals:
        # ex) [0, 1, 0] -> unwrap
        diamond, iron, stone = i
        for j in range(len(picks)):
            if picks[j] > 0 and j == 0: # 다곡인 경우
                picks[j] -= 1
                answer += diamond + iron + stone # 피로도 합
                break
            elif picks[j] > 0 and j == 1: # 철곡인 경우
                picks[j] -= 1
                answer += (5*diamond) + iron + stone
                break
            elif picks[j] > 0 and j == 2: # 돌곡인 경우
                picks[j] -= 1
                answer += (25*diamond) + (5*iron) + stone
                break
    
    return answer
