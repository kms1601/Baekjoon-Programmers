from collections import deque
import sys

input = sys.stdin.readline
DRDC = ((1, 0), (-1, 0), (0, 1), (0, -1))
n = int(input())
painting = []
queue = deque()
for _ in range(n):
    painting.append(list(input().strip()))
for blind in [False, True]:
    if blind:
        for row, line in enumerate(painting):
            for col, dot in enumerate(line):
                if dot == "G":
                    painting[row][col] = "R"
    visit = [[False] * n for _ in range(n)]
    cnt = 0
    for row, line in enumerate(visit):
        for col, dot in enumerate(line):
            if not dot:
                cnt += 1
                color = painting[row][col]
                visit[row][col] = True
                queue.append([row, col])
                while queue:
                    r, c = queue.popleft()
                    for dr, dc in DRDC:
                        nr = dr + r
                        nc = dc + c
                        if (
                            0 <= nr < n
                            and 0 <= nc < n
                            and not visit[nr][nc]
                            and painting[nr][nc] == color
                        ):
                            visit[nr][nc] = True
                            queue.append([nr, nc])
    print(cnt, end=" ")
