import sys

input = sys.stdin.readline
N = int(input())
cities = [[float('inf') for _ in range(N)] for _ in range(N)]

for _ in range(int(input())):
    a, b, c = map(int, input().split())
    if c < cities[a-1][b-1]:
        cities[a-1][b-1] = c

for k in range(N):
    for i in range(N):
        for j in range(N):
            if i == j:
                cities[i][j] = 0
            elif cities[i][k] + cities[k][j] < cities[i][j]:
                cities[i][j] = cities[i][k] + cities[k][j]
            
for city in cities:
    print(*list(map(lambda x: 0 if x == float('inf') else x, city)))