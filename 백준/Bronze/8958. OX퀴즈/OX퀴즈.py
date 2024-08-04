num = int(input())
answer = []

for _ in range(num):
    in_a_row = 0
    score = 0
    sheet = input()

    for OX in sheet:
        if OX == 'O':
            in_a_row += 1
            score += in_a_row
        else:
            in_a_row = 0
    answer.append(score)

for score in answer:
    print(score)
