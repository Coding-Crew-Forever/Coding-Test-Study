import sys

input = sys.stdin.readline

def solve(word):
    visited = [False] * len(word)

    def find_alphabet(start, end):
        if start > end:
            return

        min_idx = min(range(start, end + 1), key=lambda x: word[x])
        visited[min_idx] = True

        print(''.join(word[i] for i in range(len(word)) if visited[i]))

        find_alphabet(min_idx+1, end)
        find_alphabet(start,min_idx-1)


    find_alphabet(0, len(word)-1)


word = list(input().strip())
solve(word)


