from collections import deque

A, B = map(int, input().split())
queue = deque([[A, 1]])
answer = -1
while(queue):
    num, count = queue.popleft()
    # print(num)
    
    for n in [num * 2, num * 10 + 1]:
        if n == B:
            answer = count + 1
            break
        elif n < B:
            queue.append([n, count + 1])
print(answer)
