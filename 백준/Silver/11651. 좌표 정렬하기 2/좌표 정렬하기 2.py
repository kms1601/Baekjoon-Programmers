import sys


coor_list = []
for _ in range(int(sys.stdin.readline())):
    coor_list.append(list(map(int, sys.stdin.readline().split())))

coor_list = sorted(coor_list, key=lambda x: (x[1], x[0]))

for coor in coor_list:
    print(*coor)