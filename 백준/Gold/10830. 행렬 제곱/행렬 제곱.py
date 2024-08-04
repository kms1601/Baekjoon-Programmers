def mul(a, b):
    result = []
    for i in range(N):
        temp = []
        for j in range(N):
            sum_ = 0
            for k in range(N):
                sum_ += a[i][k] * b[k][j]
            temp.append(sum_ % 1000)
        result.append(temp)
    return result


def pow(matrix, n):
    if n == 0:
        identity = [[0 for _ in range(N)] for _ in range(N)]
        for i in range(N):
            identity[i][i] = 1
        return identity
    
    temp = pow(matrix, n // 2)
    
    if n % 2 == 0:
        return mul(temp, temp)
    else:
        return mul(mul(temp, temp), matrix)

N, B = map(int, input().split())
matrix = []
for _ in range(N):
    matrix.append(list(map(int, input().split())))

for row in pow(matrix, B):
    for col in row:
        print(col % 1000, end=' ')
    print()
