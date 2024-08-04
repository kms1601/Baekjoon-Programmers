from collections import deque

N, M = map(int, input().split())
shortcuts = {}
visit = [False for _ in range(100)]
visit[0] = True
queue = deque([[0, 0]])

for _ in range(N + M):
  start, end = map(int, input().split())
  shortcuts[start-1] = end-1

while queue:
  pos, roll = queue.popleft()
  if pos == 99:
    break
  
  for dice in range(1, 7):
    next = pos + dice
    if next < 100 and not visit[next]:
      visit[next] = True
      if next in shortcuts:
        next = shortcuts[next]
        if not visit[next]:
          visit[next] = True
          queue.append([next, roll+1])
      else:
        queue.append([next, roll+1])
print(roll)
