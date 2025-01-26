# 프로그래머스
# Lv3 입국심사

def solution(n, times):
    answer = 0
    
    left = 1
    right = max(times) * n
    
    while left <= right:
        mid = (left + right) // 2
        
        people = 0 # 심사한 사람 수
        
        for i in times:
            # 주어진 시간 동안 심사한 사람 수
            people +=  mid // i
            
            if people >= n:
                break
        
        if people >= n:
            answer = mid
            right = mid - 1
        else: # n명 미만으로 심사한 경우
            left = mid + 1
            
    return answer
