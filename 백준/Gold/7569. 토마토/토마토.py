import sys
from collections import deque

input = sys.stdin.readline
DHDRDC = ((1, 0, 0), (-1, 0, 0), (0, 1, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1))
COL, ROW, HGT = map(int, input().split())
box = []
queue = deque()
all_ripe = True

for h in range(HGT):
    floor = []
    for r in range(ROW):
        line = list(map(int, input().split()))
        floor.append(line)
        for idx, c in enumerate(line):
            if c == 1:
                queue.append([h, r, idx, 0])
    box.append(floor)
while queue:
    h, r, c, days = queue.popleft()
    for dh, dr, dc in DHDRDC:
        nh = dh + h
        nr = dr + r
        nc = dc + c
        if 0 <= nh < HGT and 0 <= nr < ROW and 0 <= nc < COL and box[nh][nr][nc] == 0:
            box[nh][nr][nc] = 1
            queue.append([nh, nr, nc, days + 1])
for h in box:
    for r in h:
        for c in r:
            if c == 0:
                all_ripe = False
print(days if all_ripe else -1)
