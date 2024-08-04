import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
infected = [False for _ in range(n)]
infected[0] = True
connected = {i + 1: [] for i in range(n)}
queue = deque([1])
cnt = 0
for _ in range(int(input())):
    a, b = map(int, input().split())
    connected[a].append(b)
    connected[b].append(a)
while queue:
    now = queue.popleft()
    for con in connected[now]:
        if not infected[con - 1]:
            cnt += 1
            infected[con - 1] = True
            queue.append(con)
print(cnt)
