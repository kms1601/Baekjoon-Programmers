from collections import deque

seq = deque()
stack = []
answer = []
number = 1
num = int(input())

for _ in range(num):
    seq.append(int(input()))

while seq:
    if seq[0] < number:
        if stack[-1] == seq[0]:
            stack.pop()
            seq.popleft()
            answer.append('-')
            continue
        else:
            answer = ['NO']
            break
    else:
        stack.append(number)
        answer.append('+')
    number += 1

for ans in answer:
    print(ans)