board = []
vertical = []

for i in range(5):
    board.append(input())
length = [len(i) for i in board]

for i in range(max(length)):
    temp = []
    for j in range(5):
        if i < length[j]:
            temp.append(board[j][i])
    vertical.append(''.join(temp))
print(''.join(vertical))
