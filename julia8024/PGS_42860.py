# 프로그래머스
# Lv2 조이스틱

def solution(name):
    
    pos_a = ord('A')
    pos_z = ord('Z')
    
    answer = float('inf')
    
    for i in range(len(name)//2 + 1):
        l_r = name[-i:] + name[:-i] # 왼쪽 먼저 + 오른쪽
        r_l = name[i::-1] + name[i+1:][::-1] # 기준점에서 뒤로 + 왼쪽
        
        for n in [l_r, r_l]:
            # 끝의 A 자르기 (필요없음)
            while n and n[-1] == 'A':
                n = n[:-1]
            
            cnt = [min(ord(c) - pos_a, (pos_z + 1) - ord(c)) for c in n]
            answer = min(answer, i + (len(cnt) -1) + sum(cnt))
    
    return answer
