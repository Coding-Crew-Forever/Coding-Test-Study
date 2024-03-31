def solution(numbers):
    answer = [-1]*len(numbers)
    stack = []
    
    for i in range(len(numbers)):
        # stack이 비어있지 않고, stack의 마지막 값(i-1)보다 현재 값이 더 큰 경우
        while stack and numbers[stack[-1]] < numbers[i]:
            # stack의 마지막 값을 제거하고
            # answer에 방금 스택에서 제거한 값을 인덱스로
            # 현재 값(numbers[i])을 넣는다
            answer[stack.pop()] = numbers[i]
        # stack에 현재 인덱스 값 삽입
        stack.append(i)

    return answer
