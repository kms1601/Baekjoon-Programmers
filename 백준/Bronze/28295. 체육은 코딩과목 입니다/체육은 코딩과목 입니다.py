direction = ['N', 'E', 'S', 'W']

for _ in range(10):
    cmd = int(input())
    if cmd == 1:
        left = direction[:1]
        right = direction[1:]
    elif cmd == 2:
        left = direction[:2]
        right = direction[2:]
    else:
        left = direction[:-1]
        right = direction[-1:]
    right.extend(left)
    direction = right
print(direction[0])