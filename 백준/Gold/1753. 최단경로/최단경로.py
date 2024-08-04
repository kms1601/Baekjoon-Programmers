import heapq
import sys

input = sys.stdin.readline
V, E = map(int, input().split())
edges = {i: [] for i in range(1, V + 1)}
K = int(input())

for _ in range(E):
    u, v, w = map(int, input().split())
    edges[u].append([w, v])

costs = [float('inf') for _ in range(V + 1)]
priority_queue = [[0, K]]
costs[K] = 0

while priority_queue:
    cost, now = heapq.heappop(priority_queue)
    
    if costs[now] < cost:
        continue
    for edge in edges[now]:
        ncost, next = edge
        if ncost + cost < costs[next]:
            costs[next] = ncost + cost
            heapq.heappush(priority_queue, [ncost + cost, next])

for cost in costs[1:]:
    if cost == float('inf'):
        print('INF')
    else:
        print(cost)
