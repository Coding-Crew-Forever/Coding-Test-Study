from itertools import permutations

def solution(numbers):
    answer = []
    nums = [i for i in numbers]
    perm = []
    
    for i in range(1, len(numbers)+1):
        perm += permutations(nums, i)
        
    new_nums = [int(("").join(i)) for i in perm]
    
    for i in new_nums:
        if i < 2:
            continue
            
        flag = True
        for n in range(2, int(i**0.5) + 1):
            if i%n == 0:
                flag = False
                break
                
        if flag:
            answer.append(i)

    return len(set(answer))
