import sys
from collections import deque

input = sys.stdin.readline
DRDC = ((1, 0), (-1, 0), (0, 1), (0, -1))
COL, ROW = map(int, input().split())
box = []
queue = deque()
all_ripe = True

for r in range(ROW):
    line = list(map(int, input().split()))
    box.append(line)
    for idx, c in enumerate(line):
        if c == 1:
            queue.append([r, idx, 0])
while queue:
    r, c, days = queue.popleft()
    for dr, dc in DRDC:
        nr = dr + r
        nc = dc + c
        if 0 <= nr < ROW and 0 <= nc < COL and box[nr][nc] == 0:
            box[nr][nc] = 1
            queue.append([nr, nc, days + 1])
for r in box:
    for c in r:
        if c == 0:
            all_ripe = False
print(days if all_ripe else -1)
