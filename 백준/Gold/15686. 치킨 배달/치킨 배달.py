from collections import deque
from itertools import combinations

DX = (1, -1, 0, 0)
DY = (0, 0, 1, -1)
N, M = map(int, input().split())
city = []
distance_list = []

for _ in range(N):
    city.append(list(map(int, input().split())))


def get_distances(house):
    result = []
    visit = [[False for _ in range(N)] for _ in range(N)]
    queue = deque([[house[0], house[1], 0]])
    visit[house[0]][house[1]] = True
    
    while (queue):
        x, y, d = queue.popleft()
        
        if city[x][y] == 2:
            result.append([x, y, d])
        
        for i in range(4):
            nx = x + DX[i]
            ny = y + DY[i]
            
            if (
                0 <= nx < N and
                0 <= ny < N and
                not visit[nx][ny]
            ):
                queue.append([nx, ny, d + 1])
                visit[nx][ny] = True
    return sorted(result, key=lambda x: (x[0], x[1]))


def get_shortest(distance, include):
    temp = []
    for store in include:
        temp.append(distance[store])
    return sorted(temp, key=lambda x: x[2])[0][2]


store_count = 0
for i, row in enumerate(city):
    for j, col in enumerate(row):
        if col == 1:
            distance_list.append(get_distances([i, j]))
        elif col == 2:
            store_count += 1

min_ = float('inf')
for include in combinations([i for i in range(len(distance_list[0]))], M):
    sum_ = 0
    for distance in distance_list:
        sum_ += get_shortest(distance, include)
        
    if sum_ < min_:
        min_ = sum_
print(min_)

