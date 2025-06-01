import sys
N = 5

board = {}
for r in range(N):
    cols = list(map(int, sys.stdin.readline().split()))
    for c in range(N):
        board[cols[c]] = (r, c)


answers = []
for _ in range(N):
    answers += list(map(int, sys.stdin.readline().split()))

# board = {11: (0, 0), 12: (0, 1), 2: (0, 2), 24: (0, 3), 10: (0, 4), 16: (1, 0), 1: (1, 1), 13: (1, 2), 3: (1, 3), 25: (1, 4), 6: (2, 0), 20: (2, 1), 5: (2, 2), 21: (2, 3), 17: (2, 4), 19: (3, 0), 4: (3, 1), 8: (3, 2), 14: (3, 3), 9: (3, 4), 22: (4, 0), 15: (4, 1), 7: (4, 2), 23: (4, 3), 18: (4, 4)}
# answers = [5, 10, 7, 16, 2, 4, 22, 8, 17, 13, 3, 18, 1, 6, 25, 12, 19, 23, 14, 21, 11, 24, 9, 20, 15]

row = [0] * N
col = [0] * N
diagonal_l = 0
diagonal_r = 0
diagonal_r_index = [(i, N-(i+1)) for i in range(N)]

call = 0
bingo = 0
while bingo < 3:
    num = answers[call]
    r,c = board[answers[call]]

    row[r] += 1
    col[c] += 1
    if row[r] == N: bingo += 1
    if col[c] == N: bingo += 1

    if r == c:
        diagonal_l += 1 # 왼쪽 대각선
        if diagonal_l == N: bingo +=1
    if (r, c) in diagonal_r_index: # 오른쪽 대각선
        diagonal_r += 1
        if diagonal_r == N: bingo += 1

    call += 1


print(call)