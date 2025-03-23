# 프로그래머스
# Lv4 징검다리

def solution(distance, rocks, n):
    
    rocks.sort()
    rocks.append(distance)
    
    low = 1
    high = distance
    
    answer = 0
    
    while low <= high:
        mid = (low + high) // 2 # 최솟값
        
        cur_rock = 0 # 왼쪽바위
        cnt = 0 # 제거된 바위 수
        
        for i in range(len(rocks)):
            pre_rock = rocks[i] # 오른쪽바위
            
            if pre_rock - cur_rock < mid:
                # mid보다 작을 경우 제거
                cnt += 1
            else:
                cur_rock = pre_rock
            
            if n < cnt:
                break
        
        if cnt <= n:
            # mid가 클수록 제거해야하는 돌이 늘어남
            answer = mid
            low = mid + 1
        
        else:
            high = mid - 1
    
                
    return answer
