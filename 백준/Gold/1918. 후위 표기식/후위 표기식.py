stack = []
result = []
for s in input():
    if 'A' <= s <= 'Z':
        result.append(s)
    elif s in ['+', '-']:
        if not stack or stack[-1] == '(':
            stack.append(s)
        else:
            while stack and stack[-1] != '(':
                result.append(stack.pop())
            stack.append(s)
    elif s in ['*', '/']:
        if not stack or stack[-1] in ['+', '-', '(']:
            stack.append(s)
        else:
            while stack and stack[-1] in ['*', '/']:
                result.append(stack.pop())
            stack.append(s)
    elif s == '(':
        stack.append('(')
    else:
        while stack:
            temp = stack.pop()
            if temp == '(':
                break
            else:
                result.append(temp)

while stack:
    result.append(stack.pop())
print(''.join(result))
