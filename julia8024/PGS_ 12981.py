def solution(n, words):
    answer = []
    
    for idx, val in enumerate(words):
        if val in words[:idx] or (idx != 0 and words[idx-1][-1] != val[0]):
            answer.append(idx % n + 1)
            answer.append(idx // n + 1)
            break

    return [0, 0] if len(answer) == 0 else answer
