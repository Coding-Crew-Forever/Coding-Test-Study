import sys
input = sys.stdin.readline

def cal(a, op, b):
    if op == '+': return a + b
    if op == '-': return a - b
    if op == '*': return a * b
    if op == '/':
        if a < 0:
            return -(-a // b)
        else:
            return a // b

def dfs (idx, val, nums, ops):
    global max_val
    global min_val

    if idx == len(nums)-1:
        max_val = max(max_val, val)
        min_val = min(min_val, val)
        return

    for i in range(len(ops)):
        if ops[i] != '':
            new_operators = ops[:]
            # print(new_operators[i], end=', ')
            new_operators[i] = ''  # 해당 연산자 하나 사용
            dfs(idx + 1, cal(val, ops[i], nums[idx + 1]), nums, new_operators)
            # print()


n = int(input())
nums = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

operators = ['+'] * add + ['-'] * sub + ['*'] * mul + ['/'] * div

max_val = float('-inf')
min_val = float('inf')

dfs(0, nums[0], nums, operators)

print(max_val)
print(min_val)
