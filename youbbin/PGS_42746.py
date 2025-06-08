def solution(numbers):
    str_numbers = list(map(str, numbers))
    str_numbers.sort(key=lambda x: x*10, reverse=True)  # (o1 + o2).compareTo(o2 + o1)과 같은 정렬

    answer = ''.join(str_numbers)
    
    # 모두 0인 경우 처리
    if answer[0] == '0':
        return '0'
    
    return answer