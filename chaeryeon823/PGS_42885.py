from collections import deque

def solution(people, limit):
    result = 0
    deque_people = deque(sorted(people))

    while deque_people:
        left = deque_people.popleft()
        if not deque_people:
            return result + 1
        right = deque_people.pop()
        if left + right > limit:
            deque_people.appendleft(left)
        result += 1
    return result

# def solution(people, limit):
#     people.sort()  
#     left, right = 0, len(people) - 1  
#     answer = 0  
#     while left <= right:
#         if people[left] + people[right] <= limit:
#             left += 1  
#         right -= 1  
#         answer += 1  
    
#     return answer

print(solution([40,55,55,60,60,70,80] , 100 ))