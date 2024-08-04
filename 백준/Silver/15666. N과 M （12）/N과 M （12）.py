from itertools import combinations_with_replacement

N, M = map(int, input().split())
result = {}

for sequence in combinations_with_replacement(sorted(list(map(int, input().split()))), M):
    result[tuple(sequence)] = 0

for key in result.keys():
    print(*key)
