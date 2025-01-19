def solution(numbers):

    sorted_numbers = sorted(map(str, numbers), key=lambda n: n * 3, reverse=True)
    print(''.join(sorted_numbers))


if __name__ == '__main__':
    user_input = input()

    numbers = list(map(int, user_input.strip("[]").split(",")))

    solution(numbers)
