def solution(s):
    answer = []
    split_list = s.replace("{{", "").replace("}}", "").split("},{")
    
    temp = sorted([list(map(int, i.split(","))) for i in split_list], key=lambda x: len(x))
    
    for i in temp:
        if len(answer) == 0:
            answer.append(i[0])
            continue
        for j in range(len(i)):
            if len(answer) != 0 and i[j] not in answer:
                answer.append(i[j])
                break

    return answer
