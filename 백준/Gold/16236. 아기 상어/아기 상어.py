from collections import deque

DX = (1, -1, 0, 0)
DY = (0, 0, 1, -1)
space = []
size = 2
eaten = 0
answer = 0
pos = [0, 0]
N = int(input())

for i in range(N):
    row = list(map(int, input().split()))
    if 9 in row:
        pos[0] = i
        pos[1] = row.index(9)
        row[pos[1]] = 0
    space.append(row)


def get_distance(pos):
    queue = deque([[pos[0], pos[1], 0]])
    times = [[-1 for _ in range(N)] for _ in range(N)]
    times[pos[0]][pos[1]] = 0

    while (queue):
        x, y, time = queue.popleft()
        
        for i in range(4):
            nx = x + DX[i]
            ny = y + DY[i]
            
            if (
                0 <= nx < N and
                0 <= ny < N and
                space[nx][ny] <= size and
                times[nx][ny] == -1
            ):
                times[nx][ny] = time + 1
                queue.append([nx, ny, time + 1])
    return times


while (True):
    min = float('inf')
    min_x, min_y = 0, 0
    times = get_distance(pos)
    for x, row in enumerate(times):
        for y, time in enumerate(row):
            if time < min and 0 < space[x][y] < size and time > 0:
                min = time
                min_x, min_y = x, y
                
    if min == float('inf'):
        break

    pos = [min_x, min_y]
    space[min_x][min_y] = 0
    answer += times[min_x][min_y]
    eaten += 1
    if eaten == size:
        eaten = 0
        size += 1
print(answer)
