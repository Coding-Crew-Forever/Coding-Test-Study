from itertools import permutations

def solution(k, dungeons):
    answer = 0
    
    for dungeon in permutations(dungeons, len(dungeons)):
        temp = k
        cnt = 0
        
        for need, speed in dungeon:
            if temp >= need:
                temp -= speed
                cnt += 1
                
        answer = max(answer, cnt)
    return answer
