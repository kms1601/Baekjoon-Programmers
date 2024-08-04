from collections import deque
import sys

input = sys.stdin.readline

queue = deque([1])
answer = 0
N, M = map(int, input().split())
visit = [False for _ in range(N)]
nodes = {i + 1: [] for i in range(N)}

for _ in range(M):
    u, v = map(int, input().split())
    nodes[u].append(v)
    nodes[v].append(u)

for i, v in enumerate(visit):
    if not v:
        answer += 1
        queue.append(i + 1)
        visit[i] = True

        while queue:
            now = queue.popleft()

            for next in nodes[now]:
                if not visit[next - 1]:
                    visit[next - 1] = True
                    queue.append(next)
print(answer)
