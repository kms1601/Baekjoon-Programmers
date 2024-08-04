from itertools import permutations

N, M = map(int, input().split())

for sequence in permutations(sorted(list(map(int, input().split()))), M):
    print(*sequence)
