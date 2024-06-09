import heapq

def solution(scoville, K):
    answer = 0 # 섞은 횟수
    heap = [] #힙
    
    # 힙에 기존값 모두 추가
    for i in scoville:
        heapq.heappush(heap, i)
    

    while(heap[0] < K):
        heapq.heappush(heap, heapq.heappop(heap) + heapq.heappop(heap)*2)
        answer += 1
        
        # 더이상 섞을 수 없고, 스코빌 지수가 K 이상을 만족하지 못하는 경우
        if len(heap) < 2 and heap[0] < K:
            return -1
    
    return answer
