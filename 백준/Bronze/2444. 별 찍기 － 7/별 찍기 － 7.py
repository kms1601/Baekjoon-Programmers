num = int(input())

for line in range(1, 2 * num):
    print(f'{" " * (num-line)}{"*" * (2*line - 1)}' if line <= num else f'{" " * (line - num)}{"*" * (2*(2*num - line) - 1)}')