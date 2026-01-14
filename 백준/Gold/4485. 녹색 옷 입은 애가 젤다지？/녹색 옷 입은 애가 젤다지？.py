import sys
import heapq

input = sys.stdin.readline
DR = (1, -1, 0, 0)
DC = (0, 0, 1, -1)

problem = 1
while True:
    N = int(input())
    if N == 0:
        break
    
    _map = []
    for _ in range(N):
        _map.append(list(map(int, input().split())))
    
    _min = [[125 * 81 for _ in range(N)] for _ in range(N)]
    _min[0][0] = _map[0][0]
    heap = [(0, 0)]
    while heap:
        r, c = heapq.heappop(heap)
        for i in range(4):
            nr = r + DR[i]
            nc = c + DC[i]
            if 0 <= nr < N and 0 <= nc < N and _min[r][c] + _map[nr][nc] < _min[nr][nc]:
                _min[nr][nc] = _min[r][c] + _map[nr][nc]
                heapq.heappush(heap, (nr, nc))
    
    print(f"Problem {problem}: {_min[N - 1][N - 1]}")
    problem += 1
