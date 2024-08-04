import sys


sys.setrecursionlimit(10000000)
DRDC = [[1, 0], [-1, 0], [0, 1], [0, -1]]


def check_cabbage(row, column, field):
    if (
        row < 0
        or column < 0
        or row >= len(field)
        or column >= len(field[0])
        or field[row][column] == 0
    ):
        return False
    else:
        field[row][column] = 0

        for dr, dc in DRDC:
            check_cabbage(row + dr, column + dc, field)
    return True


for _ in range(int(sys.stdin.readline())):
    worm = 0
    m, n, k = map(int, sys.stdin.readline().split())
    field = [[0] * n for _ in range(m)]

    for _ in range(k):
        row, column = map(int, sys.stdin.readline().split())
        field[row][column] = 1

    for row in range(m):
        for column in range(n):
            if check_cabbage(row, column, field):
                worm += 1
    print(worm)
