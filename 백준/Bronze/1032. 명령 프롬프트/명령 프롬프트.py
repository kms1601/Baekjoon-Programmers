from functools import reduce


def change(c1, c2):
    if c1 == c2:
        return c1
    else:
        return '?'


num = int(input())
prompt = []
answer = []

for _ in range(num):
    prompt.append(input())

for idx in range(len(prompt[0])):
    temp = []
    for cha in prompt:
        temp.append(cha[idx])
    answer.append(reduce(change, temp))
print(''.join(answer))
