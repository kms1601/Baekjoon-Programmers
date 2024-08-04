num = int(input())
money_list = [25, 10, 5, 1]
answer = []

for _ in range(num):
    temp = []
    remain = int(input())
    for money in money_list:
        temp.append(remain // money)
        remain %= money
    answer.append(temp)

for ans in answer:
    print(*ans)
    