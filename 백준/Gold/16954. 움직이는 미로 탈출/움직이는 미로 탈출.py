import sys
from collections import deque

input = sys.stdin.readline

DR = (-1, -1, -1, 0, 0, 0, 1, 1, 1)
DC = (-1, 0, 1, -1, 0, 1, -1, 0, 1)


def fall(board):
    result = set()
    for wall in board:
        if wall[0] != 7:
            result.add((wall[0] + 1, wall[1]))
    return result
    
board = set()
for r in range(8):
    row = input()
    for c, ch in enumerate(row):
        if ch == "#":
            board.add((r, c))

state = []
while True:
    state.append(board)
    board = fall(board)
    if not board:
        state.append(board)
        break

queue = deque()
queue.append(((7, 0), 0))
while queue:
    cur, time = queue.popleft()
    r, c = cur
    for i in range(9):
        nr = r + DR[i]
        nc = c + DC[i]
        if 0 <= nr < 8 and 0 <= nc < 8 and not (nr, nc) in state[time] and not (nr, nc) in state[time + 1]:
            if time == len(state) - 2:
                print(1)
                sys.exit(0)
            else:
                queue.append(((nr, nc), time + 1))

print(0)
