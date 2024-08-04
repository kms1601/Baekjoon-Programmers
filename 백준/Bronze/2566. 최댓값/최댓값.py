matrix = []
max_val = -1
max_row = 0
max_column = 0
for idx in range(9):
    matrix.append(list(map(int, input().split())))

for row, arr in enumerate(matrix):
    for column, value in enumerate(arr):
        if max_val < value:
            max_val = value
            max_row = row + 1
            max_column = column + 1
print(f'{max_val}\n{max_row} {max_column}')
