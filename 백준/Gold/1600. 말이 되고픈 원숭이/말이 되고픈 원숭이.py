import sys
from collections import deque

input = sys.stdin.readline

DH = [1, -1, 0, 0]
DW = [0, 0, 1, -1]
KNIGHT_DH = [1, -1, 2, -2, 2, -2, 1, -1]
KNIGHT_DW = [-2, -2, -1, -1, 1, 1, 2, 2]


def is_valid(world: list[list[int]], visit: list[list[list[int]]], cur: tuple[int, int, int],
             consts: tuple[int, int]) -> bool:
    H, W = consts
    k, h, w = cur
    return 0 <= h < H and 0 <= w < W and not visit[k][h][w] and world[h][w] == 0


def bfs(world: list[list[int]], consts: tuple[int, int, int]) -> int:
    K, H, W = consts
    queue = deque()
    queue.appendleft((K, 0, 0))
    visit = [[[0 for _ in range(W)] for _ in range(H)] for _ in range(K + 1)]
    visit[K][0][0] = 0
    while queue:
        cur = queue.pop()
        k, h, w = cur
        if h == H - 1 and w == W - 1:
            return visit[k][h][w]
        if k > 0:
            for i in range(8):
                nk = k - 1
                nh = h + KNIGHT_DH[i]
                nw = w + KNIGHT_DW[i]
                if is_valid(world, visit, (nk, nh, nw), (H, W)):
                    queue.appendleft((nk, nh, nw))
                    visit[nk][nh][nw] = visit[k][h][w] + 1
        for i in range(4):
            nh = h + DH[i]
            nw = w + DW[i]
            if is_valid(world, visit, (k, nh, nw), (H, W)):
                queue.appendleft((k, nh, nw))
                visit[k][nh][nw] = visit[k][h][w] + 1

    return -1


def main():
    K = int(input())
    W, H = map(int, input().split())
    world = []
    for h in range(H):
        world.append(list(map(int, input().split())))

    print(bfs(world, (K, H, W)))


if __name__ == '__main__':
    main()
