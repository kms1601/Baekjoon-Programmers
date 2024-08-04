import sys
from collections import deque

input = sys.stdin.readline
SIZE = int(input())
DRDC = ((1, 0), (-1, 0), (0, 1), (0, -1))
queue = deque()
map = []
complexes = []
for _ in range(SIZE):
    map.append(list(input().strip()))
for idx1, line in enumerate(map):
    for idx2, point in enumerate(line):
        if point == "1":
            map[idx1][idx2] = "0"
            queue.append([idx1, idx2])
            cnt = 0
            while queue:
                cnt += 1
                row, col = queue.popleft()
                for dr, dc in DRDC:
                    nrow = row + dr
                    ncol = col + dc
                    if 0 <= nrow < SIZE and 0 <= ncol < SIZE and map[nrow][ncol] == "1":
                        queue.append([nrow, ncol])
                        map[nrow][ncol] = "0"
            complexes.append(cnt)
print(len(complexes))
complexes.sort()
for complex in complexes:
    print(complex)
