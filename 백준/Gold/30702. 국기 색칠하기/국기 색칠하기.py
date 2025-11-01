import sys
from collections import deque

input = sys.stdin.readline

DX = [1, -1, 0, 0]
DY = [0, 0, 1, -1]


def get_shapes(flag: list[list[str]], N: int, M: int) -> list[list[tuple[int, int]]]:
    shapes = []
    visit = [[False] * M for _ in range(N)]
    for n in range(N):
        for m in range(M):
            if visit[n][m]:
                continue
            shape = []
            queue = deque()
            queue.appendleft((n, m))
            visit[n][m] = True
            color = flag[n][m]
            while queue:
                x, y = queue.pop()
                shape.append((x, y))
                for i in range(4):
                    nx = x + DX[i]
                    ny = y + DY[i]
                    if 0 <= nx < N and 0 <= ny < M and not visit[nx][ny] and flag[nx][ny] == color:
                        visit[nx][ny] = True
                        queue.append((nx, ny))
            shapes.append(shape)
    return shapes


def main():
    N, M = map(int, input().split())
    flag1 = []
    flag2 = []
    for _ in range(N):
        flag1.append(list(input().strip()))
    for _ in range(N):
        flag2.append(list(input().strip()))

    flag1_shapes = get_shapes(flag1, N, M)
    for shape in flag1_shapes:
        color = flag2[shape[0][0]][shape[0][1]]
        for n, m in shape:
            flag1[n][m] = color

    if flag1 == flag2:
        print("YES")
    else:
        print("NO")


if __name__ == '__main__':
    main()
