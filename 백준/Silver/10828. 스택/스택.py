import sys


input = sys.stdin.readline
stack = []

for _ in range(int(input())):
    user_input = input().split()
    
    if user_input[0] == 'push':
        stack.append(user_input[1])
    elif user_input[0] == 'pop':
        if stack:
            print(stack.pop())
        else:
            print(-1)
    elif user_input[0] == 'size':
        print(len(stack))
    elif user_input[0] == 'empty':
        if stack:
            print(0)
        else:
            print(1)
    elif user_input[0] == 'top':
        if stack:
            print(stack[-1])
        else:
            print(-1)