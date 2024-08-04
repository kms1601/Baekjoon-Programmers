n, m = map(int, input().split())
template = [['WBWBWBWB', 'BWBWBWBW'], ['BWBWBWBW', 'WBWBWBWB']]
answer = float('inf')
board = []

for _ in range(n):
    board.append(input())

for i in range(n - 7):
    for j in range(m - 7):
        cutting_board = []
        for k in range(8):
            cutting_board.append(board[i+k][j:j+8])

        for tem_idx in range(2):
            change = 0
            for row in range(4):
                for column in range(8):
                    if cutting_board[2*row][column] != template[tem_idx][0][column]:
                        change += 1
                    if cutting_board[2*row + 1][column] != template[tem_idx][1][column]:
                        change += 1
            if change < answer:
                answer = change
print(answer)
