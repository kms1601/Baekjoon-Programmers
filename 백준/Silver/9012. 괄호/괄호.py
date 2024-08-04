import sys


input = sys.stdin.readline

for _ in range(int(input())):
    stack = []
    par = input()

    for cha in par[:-1]:
        if cha == '(':
            stack.append(cha)
        else:
            if not stack or stack[-1] != '(':
                stack.append('NO')
                break
            else:
                stack.pop()
    if not stack:
        print('YES')
    else:
        print('NO')