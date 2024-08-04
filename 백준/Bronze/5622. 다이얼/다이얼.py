num_dict = {'ABC': 3, 'DEF': 4, 'GHI': 5, 'JKL': 6, 'MNO': 7, 'PQRS': 8, 'TUV': 9, 'WXYZ': 10}
call = input()
answer = 0

for chra in call:
    for dial in num_dict:
        if chra in dial:
            answer += num_dict[dial]
            break
print(answer)
