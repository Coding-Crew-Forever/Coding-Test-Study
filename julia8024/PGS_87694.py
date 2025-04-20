# 프로그래머스
# Lv3 아이템 줍기

from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    graph = [[-1 for _ in range(102)] for _ in range(102)]
    visited = [[1 for _ in range(102)] for _ in range(102)]
    direction = [(0, -1), (1, 0), (0, 1), (-1, 0)]
    dq = deque()
    
    
    # 테두리 =1, 내부 =0, 외부 =-1로 만들기
    for r in rectangle:
        x1, y1, x2, y2 = map(lambda x: x*2, r)
        for i in range(x1, x2+1):
            for j in range(y1, y2+1):
                if x1 < i < x2 and y1 < j < y2:
                    graph[i][j] = 0
                # 다른 직사각형의 내부가 아니면서 테두리일 때 1로 채우기
                elif graph[i][j] != 0:
                    graph[i][j] = 1
    
    cx, cy, ix, iy = 2*characterX, 2*characterY, 2*itemX, 2*itemY
    
    dq.append((cx, cy))
    
    while dq:
        x, y = dq.popleft()
        
        if x == ix and y == iy:
            answer = visited[x][y] // 2
            break
        for k in range(4):
            nx, ny = x + direction[k][0], y + direction[k][1]
            
            if graph[nx][ny] == 1 and visited[nx][ny] == 1:
                visited[nx][ny] += visited[x][y]
                dq.append((nx, ny))
                
    return answer
