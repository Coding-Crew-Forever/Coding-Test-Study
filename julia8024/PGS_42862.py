# 프로그래머스
# Lv1 체육복

def solution(n, lost, reserve):
    # 혹시 모르니 정렬부터
    lost.sort()
    reserve.sort()
    
    # 여벌 체육복이 있는 학생이 도난당한 경우 제거
    
    # reserve 리스트가 for문 내부에서 참조하는 값의 인덱스가 바뀌고 있기 때문에
    # 바로 참조하지 않고 reserve[:]로 리스트 전체 복사해서 사용해주기
    for i in reserve[:]:
        if i in lost:
            lost.remove(i)
            reserve.remove(i)
    
    # 체육복 빌려주기 (앞번호부터 확인)
    for i in reserve:
        if i-1 in lost:
            lost.remove(i-1)
        elif i+1 in lost:
            lost.remove(i+1)
        
    # 도난당한 학생 수 - 체육복 못 빌린 학생 수
    return n - len(lost)
