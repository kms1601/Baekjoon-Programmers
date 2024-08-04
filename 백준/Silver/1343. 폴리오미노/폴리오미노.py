import re

board = re.findall(r'[X]+|[.]+', input())
answer = []

for block in board:
    if block[0] == '.':
        answer.append(block)
    else:
        length = len(block)
        if length % 2 == 1:
            answer = ['-1']
            break
        answer.append('AAAA' * (length // 4))
        answer.append('BB' * ((length % 4) // 2))
print(''.join(answer))
