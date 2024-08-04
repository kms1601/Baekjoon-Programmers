row, column = map(int, input().split())
matrix1 = []
matrix2 = []

for i in range(row):
    matrix1.append(list(map(int, input().split())))
for i in range(row):
    matrix2.append(list(map(int, input().split())))

for i in range(row):
    for j in range(column):
        print(matrix1[i][j] + matrix2[i][j], end=' ')
    print()
    