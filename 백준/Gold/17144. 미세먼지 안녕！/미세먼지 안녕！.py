import sys


DR = (1, -1, 0, 0)
DC = (0, 0, 1, -1)


def spread():
    update = [[0 for _ in range(C)] for _ in range(R)]
    for r in range(R):
        for c in range(C):
            if room[r][c] > 0:
                amount = room[r][c] // 5

                for i in range(4):
                    nr = r + DR[i]
                    nc = c + DC[i]

                    if (
                        0 <= nr < R and
                        0 <= nc < C and
                        not room[nr][nc] == -1
                    ):
                        update[nr][nc] += amount
                        update[r][c] -= amount

    for r in range(R):
        for c in range(C):
            room[r][c] += update[r][c]


def circulation():
    room[cleaner - 1][0] = 0
    for r in range(cleaner - 2, -1, -1):
        room[r + 1][0] = room[r][0]
    for c in range(1, C):
        room[0][c - 1] = room[0][c]
    for r in range(1, cleaner + 1):
        room[r - 1][-1] = room[r][-1]
    for c in range(C - 2, 0, -1):
        room[cleaner][c + 1] = room[cleaner][c]
    room[cleaner][1] = 0

    room[cleaner + 2][0] = 0
    for r in range(cleaner + 3, R):
        room[r - 1][0] = room[r][0]
    for c in range(1, C):
        room[-1][c - 1] = room[-1][c]
    for r in range(R - 2, cleaner, -1):
        room[r + 1][-1] = room[r][-1]
    for c in range(C - 2, 0, -1):
        room[cleaner + 1][c + 1] = room[cleaner + 1][c]
    room[cleaner + 1][1] = 0


input = sys.stdin.readline
R, C, T = map(int, input().split())
room = []
for _ in range(R):
    room.append(list(map(int, input().split())))

cleaner = 0
for r in range(R):
    if room[r][0] == -1:
        cleaner = r
        break

for _ in range(T):
    spread()
    circulation()

sum_ = 0
for r in room:
    for c in r:
        if c > 0:
            sum_ += c
print(sum_)
