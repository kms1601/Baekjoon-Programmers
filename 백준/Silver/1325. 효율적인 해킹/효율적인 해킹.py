import sys
from collections import deque

input = sys.stdin.readline


def bfs(computers: list[list[int]], cur: int) -> int:
    count = 0
    visited = [False for _ in computers]
    queue = deque([cur])
    visited[cur] = True
    while queue:
        count += 1
        cur = queue.pop()
        for n in computers[cur]:
            if not visited[n]:
                visited[n] = True
                queue.append(n)
    return count


def main():
    N, M = map(int, input().split())
    computers = [[] for _ in range(N + 1)]
    for m in range(M):
        a, b = map(int, input().split())
        computers[b].append(a)

    _max = 0
    result = []
    for i in range(1, N + 1):
        count = bfs(computers, i)

        if count > _max:
            _max = count
            result = []

        if count == _max:
            result.append(i)
    print(" ".join(map(str, result)))


if __name__ == '__main__':
    main()
