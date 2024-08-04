from collections import deque

N, K = map(int, input().split())
visit = [float('inf') for _ in range(100001)]
queue = deque([[N, 0]])
visit[N] = 0
while queue:
    pos, time = queue.popleft()
    
    if pos - 1 >= 0 and time + 1 < visit[pos - 1]:
        queue.append([pos - 1, time + 1])
        visit[pos - 1] = time + 1

    if pos + 1 <= 100000 and time + 1 < visit[pos + 1]:
        queue.append([pos + 1, time + 1])
        visit[pos + 1] = time + 1

    if pos * 2 <= 100000 and time < visit[pos * 2]:
        queue.append([pos * 2, time])
        visit[pos * 2] = time

print(visit[K])
