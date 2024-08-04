from collections import deque


people, k = map(int, input().split())
queue = deque([str(i + 1) for i in range(people)])
josephus = []
cnt = 1

while queue:
    if cnt % k == 0:
        josephus.append(queue.popleft())
    else:
        queue.append(queue.popleft())
    cnt += 1
print("<" + ", ".join(josephus) + ">")
