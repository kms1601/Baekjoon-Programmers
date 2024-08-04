from itertools import combinations_with_replacement

N, M = map(int, input().split())

for sequence in combinations_with_replacement(sorted(list(map(int, input().split()))), M):
    print(*sequence)
