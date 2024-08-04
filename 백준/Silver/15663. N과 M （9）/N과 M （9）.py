from itertools import permutations

N, M = map(int, input().split())
result = {}

for sequence in permutations(sorted(list(map(int, input().split()))), M):
    result[tuple(sequence)] = 0

for key in result.keys():
    print(*key)
