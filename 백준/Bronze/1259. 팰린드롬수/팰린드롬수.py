num_list = []
answer = []

while True:
    num = input()
    num_list.append(num)
    if num == '0':
        break

for num in num_list[:-1]:
    answer.append('yes')
    for idx in range(len(num)//2):
        if num[idx] != num[-(idx+1)]:
            answer.pop()
            answer.append('no')
            break

for num in answer:
    print(num)
    