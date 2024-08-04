N = int(input())
triangle = []

for _ in range(N):
    triangle.append(list(map(int, input().split())))

triangle.append([0] * (N + 1))

for i in range(N - 1, -1, -1):
    for j in range(i + 1):
        triangle[i][j] = triangle[i][j] + max(triangle[i + 1][j], triangle[i + 1][j + 1])
print(max(triangle[0]))