import math

def solution(progresses, speeds):
    # 작업이 완료되는 (배포가 가능한) 일자 -> [7, 3, 9] 형태
    arr = list(map(lambda x, y: math.ceil((100 - x) / y), progresses, speeds))
    result = []
    
    # 재귀함수 호출
    def compareSpeeds(arr, firstIdx, nowIdx, time, result):
        # index out of range
        if nowIdx > len(arr)-1:
            result.append(time)
            return result
        
        # 앞선 작업보다 빠르게 완료된 경우 함께 배포
        if arr[firstIdx] >= arr[nowIdx]:
            return compareSpeeds(arr, firstIdx, nowIdx+1, time+1, result)
        else:
            result.append(time)
            return compareSpeeds(arr, nowIdx, nowIdx+1, 1, result)
    
    return compareSpeeds(arr, 0, 1, 1, [])
