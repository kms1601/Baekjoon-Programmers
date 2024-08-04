from itertools import combinations

N, M = map(int, input().split())

for comb in combinations([i for i in range(1, N + 1)], M):
    print(*comb)