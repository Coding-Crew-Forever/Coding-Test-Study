import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
dq = deque()
out_lines = []

for _ in range(N):
    cmd = input().split()

    if cmd[0] == "push_front":
        x = int(cmd[1])
        dq.appendleft(x)
    elif cmd[0] == "push_back":
        x = int(cmd[1])
        dq.append(x)
    elif cmd[0] == "pop_front":
        if dq:
            out_lines.append(str(dq.popleft()))
        else:
            out_lines.append("-1")
    elif cmd[0] == "pop_back":
        if dq:
            out_lines.append(str(dq.pop()))
        else:
            out_lines.append("-1")
    elif cmd[0] == "size":
        out_lines.append(str(len(dq)))
    elif cmd[0] == "empty":
        out_lines.append("0" if dq else "1")
    elif cmd[0] == "front":
        if dq:
            out_lines.append(str(dq[0]))
        else:
            out_lines.append("-1")
    elif cmd[0] == "back":
        if dq:
            out_lines.append(str(dq[-1]))
        else:
            out_lines.append("-1")

sys.stdout.write("\n".join(out_lines))
