from collections import deque
import sys

input = sys.stdin.readline
DRDC = ((1, 0), (-1, 0), (0, 1), (0, -1))
ROW, COL = map(int, input().split())
visit = [[False] * COL for _ in range(ROW)]
queue = deque([[0, 0, 1]])
maze = []
for _ in range(ROW):
    maze.append(list(input()))

while queue:
    row, col, move = queue.popleft()

    if row == ROW - 1 and col == COL - 1:
        break

    for dr, dc in DRDC:
        if not (0 <= row + dr < ROW and 0 <= col + dc < COL):
            continue
        if maze[row + dr][col + dc] == "1" and not visit[row + dr][col + dc]:
            queue.append([row + dr, col + dc, move + 1])
            visit[row + dr][col + dc] = True
print(move)
