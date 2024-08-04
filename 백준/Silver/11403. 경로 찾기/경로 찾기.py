N = int(input())
map_ = []
for _ in range(N):
    map_.append(list(map(int, input().split())))

for k in range(N):
    for i in range(N):
        for j in range(N):
            if map_[i][k] and map_[k][j]:
                map_[i][j] = 1

for row in map_:
    for col in row:
        print(col, end=' ')
    print()
