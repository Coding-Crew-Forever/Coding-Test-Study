def solution(numbers):
    # 1. numbers 리스트를 문자열 배열로 [10, 4, 6] => ["10", "4", "6"]
    # 2. x*4 => 모두 최대 자리수로 (1000의 자리) 맞춰주고 내림차순 정렬
    # 3. 정렬 후 문자열로 합쳤다가, 정수형 -> 문자열로 변환하여 반환
    # - ["0", "0", "0"]인 경우 join하면 000으로 되기 때문에 이 경우를 위한 절차
    return str(int("".join(sorted(list(map(str, numbers)), key=lambda x: x*4, reverse=True))))
