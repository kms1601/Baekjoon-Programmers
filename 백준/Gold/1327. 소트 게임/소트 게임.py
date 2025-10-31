import sys
from collections import deque

input = sys.stdin.readline


def main():
    N, K = map(int, input().split())
    seq = list(map(int, input().split()))
    target = str([i + 1 for i in range(N)])

    visited = set()
    visited.add(str(seq))
    seq.append(0)
    queue = deque()
    queue.appendleft(seq)
    while queue:
        cur = queue.pop()
        if str(cur[:N]) == target:
            print(cur[N])
            return
        for i in range(N - K + 1):
            mid = cur[i: i + K]
            mid.reverse()
            change = cur[:i] + mid + cur[i + K:N]
            if str(change) not in visited:
                queue.appendleft(change + [cur[N] + 1])
                visited.add(str(change))
    print(-1)

if __name__ == '__main__':
    main()
