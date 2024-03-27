def solution(genres, plays):
    answer = []
    dicts = {i:0 for i in list(set(genres))}
    
    # 데이터 : [[장르, 재생횟수, idx값], ... ]
    info_list = [[genres[i], plays[i], i] for i in range(len(genres))]
    
    # 데이터 정렬
    info_list.sort(key=lambda x: (x[0], -x[1], x[2]))
    
    # 장르별 총 재생횟수
    for i in range(len(genres)):
        dicts[genres[i]] += plays[i]
    
    # 더 많이 재생된 장르 순서대로 정렬!!
    sorted_dicts = sorted(dicts.items(), key=lambda x: -x[1])
    
    # 장르별 최대 2곡씩, 재생횟수 많은 순
    for i in sorted_dicts:
        cnt = 0
        for j in info_list:
            if i[0] == j[0]:
                cnt += 1
                if cnt > 2:
                    break
                else:
                    answer.append(j[2])
    
    return answer
