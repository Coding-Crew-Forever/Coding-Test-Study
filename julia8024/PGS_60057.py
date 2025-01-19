# 프로그래머스
# Lv2 문자열 압축

def setResult(result, cnt, now):
    if cnt >= 2: # 한 번 이상 중복된 문자열을 찾은 경우
        result += str(cnt) + now
    else:
        result += now
    return result

def solution(s):
    answer = len(s)
    result = ''
    
    for num in range(1, len(s)//2+1):
        # 현재 비교할 값
        now = s[:num]
        cnt = 1
        for i in range(num, len(s), num):
            nex = s[i:i+num]
            if now == nex:
                cnt += 1
            else:
                result = setResult(result, cnt, now)
                now = nex
                cnt = 1
        # 나머지 처리
        result = setResult(result, cnt, now)
        
        # 최솟값 찾기
        answer = min(answer, len(result))
        result = ''
        
    return answer
