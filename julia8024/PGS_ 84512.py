# 경우의 수로 풀이
def solution(word):
    answer = 0
    dics = {'A': 0, 'E': 1, 'I': 2, 'O': 3, 'U': 4}
    for i in range(len(word)):
        answer += 1 + dics[word[i]] * ((5 ** (5-i) -1) / 4)
    return answer
