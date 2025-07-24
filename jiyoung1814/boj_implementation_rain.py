import sys

if __name__ == "__main__":

    input = sys.stdin.readline

    height, width = map(int, input().split())
    blocks = list(map(int, input().split()))

    blocks_arr = [[0] * width for _ in range(height)]

    for c in range(width):
        h = blocks[c]

        for r in range(height - h, height):
            blocks_arr[r][c] = 1

    rain = 0

    for row in blocks_arr:

        if not 0 in row or not 1 in row:
            continue

        left = None

        for i, v in enumerate(row):
            if v == 1:
                if left is None:
                    left = i
                else:
                    rain += (i - left - 1)
                    left = i

    print(rain)