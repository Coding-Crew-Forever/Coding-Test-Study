def solution(numbers, target):
    answer = 0

    def dfs(depth, result):
        nonlocal answer
        if depth == len(numbers):
            if result == target:
                answer += 1
        else:
            dfs(depth + 1, result + numbers[depth])
            dfs(depth + 1, result - numbers[depth])

    dfs(0, 0)
    return answer