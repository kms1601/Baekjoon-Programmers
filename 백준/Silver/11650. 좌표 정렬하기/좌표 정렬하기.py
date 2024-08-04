import sys


input = sys.stdin.readline
coor = []

for _ in range(int(input())):
    coor.append(list(map(int, input().split())))

coor = sorted(coor, key=lambda x: (x[0], x[1]))

for x, y in coor:
    print(x, y)