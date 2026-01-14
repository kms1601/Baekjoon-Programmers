import sys
from collections import deque

input = sys.stdin.readline
DH = (1, -1, 0, 0)
DW = (0, 0, 1, -1)


while True:
    W, H = map(int, input().split())
    if H == 0 and W == 0:
        break
    
    room = []
    sh, sw = 0, 0
    for h in range(H):
        room.append(input())
    
    for h in range(H):
        if "@" in room[h]:
            sh, sw = h, room[h].index("@")
            break
    
    count = 0
    queue = deque()
    queue.append((sh, sw))
    visited = [[False for _ in range(W)] for _ in range(H)]
    visited[sh][sw] = True
    while (queue):
        h, w = queue.popleft()
        count += 1
        for i in range(4):
            nh = h + DH[i]
            nw = w + DW[i]
            if 0 <= nh < H and 0 <= nw < W and not room[nh][nw] == "#" and not visited[nh][nw]:
                visited[nh][nw] = True
                queue.append((nh, nw))
    print(count)
        
   