from collections import deque

DX = (1, -1, 0, 0)
DY = (0, 0, 1, -1)


def get_outside():
    visit = [[False for _ in range(M)] for _ in range(N)]
    visit[0][0] = True
    queue = deque([[0, 0]])
    while queue:
        x, y = queue.pop()

        for i in range(4):
            nx = x + DX[i]
            ny = y + DY[i]
            if (
                0 <= nx < N and
                0 <= ny < M and
                not visit[nx][ny] and
                cheese[nx][ny] == 0
            ):
                queue.append([nx, ny])
                visit[nx][ny] = True
    return visit


N, M = map(int, input().split())
count = 0
cheese = []
for _ in range(N):
    row = list(map(int, input().split()))
    count += sum(row)
    cheese.append(row)

time = 0
while count != 0:
    outside = get_outside()

    for x in range(N):
        for y in range(M):
            if cheese[x][y] == 1:
                exposed = 0

                for i in range(4):
                    nx = x + DX[i]
                    ny = y + DY[i]

                    if outside[nx][ny]:
                        exposed += 1
                if exposed >= 2:
                    cheese[x][y] = 0
                    count -= 1
    time += 1
print(time)
