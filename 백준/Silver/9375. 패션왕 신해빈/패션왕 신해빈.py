from collections import defaultdict
from itertools import combinations

for _ in range(int(input())):
    closet = defaultdict(int)

    for _ in range(int(input())):
        _, kind = input().split()
        closet[kind] += 1

    count = 1
    for kind in closet:
        count *= closet[kind] + 1
    print(count - 1)
