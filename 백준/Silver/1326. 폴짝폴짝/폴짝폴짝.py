import sys
from collections import deque

input = sys.stdin.readline


def main():
    N = int(input())
    bridge = list(map(int, input().split()))
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    queue = deque()
    queue.appendleft(a)
    visit = [-1 for _ in range(N)]
    visit[a] = 0
    while queue:
        cur = queue.pop()
        count = visit[cur]
        next = cur
        while next + bridge[cur] < N: # move forward
            next += bridge[cur]
            if visit[next] == -1:
                queue.appendleft(next)
                visit[next] = count + 1
                
        next = cur
        while next - bridge[cur] >= 0: # move backward
            next -= bridge[cur]
            if visit[next] == -1:
                queue.appendleft(next)
                visit[next] = count + 1
    print(visit[b])
    

if __name__ == "__main__":
    main()