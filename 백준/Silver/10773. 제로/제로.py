import sys

n = int(sys.stdin.readline())
stack = []

for i in range(n):
    num = int(sys.stdin.readline())
    
    if num:
        stack.append(num)
    else:
        stack.pop()
print(sum(stack))