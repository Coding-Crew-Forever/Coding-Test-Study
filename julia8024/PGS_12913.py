def solution(land):
    tmp = land
    
    for i in range(1, len(land)):
        for j in range(4):
            tmp[i][j] += max(tmp[i-1][:j] + tmp[i-1][j+1:])
        

    return max(tmp[len(tmp)-1])
