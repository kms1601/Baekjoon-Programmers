import sys
from collections import deque


input = sys.stdin.readline
queue = deque()

for _ in range(int(input())):
    user_input = input().split()
    
    if user_input[0] == 'push_front':
        queue.appendleft(user_input[1])
    elif user_input[0] == 'push_back':
        queue.append(user_input[1]) 
    elif user_input[0] == 'pop_front':
        if queue:
            print(queue.popleft())
        else:
            print(-1) 
    elif user_input[0] == 'pop_back':
        if queue:
            print(queue.pop())
        else:
            print(-1)
    elif user_input[0] == 'size':
        print(len(queue))
    elif user_input[0] == 'empty':
        if queue:
            print(0)
        else:
            print(1)
    elif user_input[0] == 'front':
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif user_input[0] == 'back':
        if queue:
            print(queue[-1])
        else:
            print(-1)