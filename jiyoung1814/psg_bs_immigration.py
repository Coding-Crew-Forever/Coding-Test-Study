def solution(number, times):

    start = times[0]
    end = number * times[-1]
    answer = end

    while start <= end:
        mid = (start + end) // 2
        cnt = sum(mid // t for t in times)

        if cnt < number:
            start = mid +1
        elif cnt >= number:
            answer = mid
            end = mid -1

    return answer


if __name__ == '__main__':
    n = int(input())
    times = list(map(int, input().split()))
    result = solution(n, times)
    print(result)