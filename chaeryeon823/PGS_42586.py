# 기능 개발
# lv 2
# 구현

def solution(progresses, speeds):
    time = []
    answer = []
    for progress in progresses:
        time.append(100 - progress)
        
    for i in range(len(speeds)):
        if time[i] % speeds[i] == 0:
            time[i] = time[i] // speeds[i]
        else:
            time[i] = (time[i] // speeds[i]) + 1
    
    tmp = time[0]
    cnt = 1
    for i in range(1, len(time)):
        if time[i] > tmp:
            tmp = time[i]
            answer.append(cnt)
            cnt = 1
        else:
            cnt += 1
            
    answer.append(cnt)
    return answer

print(solution([93, 30, 55], [1, 30, 5]))