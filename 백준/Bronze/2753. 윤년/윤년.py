import sys

input = int(sys.stdin.readline())
print(1 * (0 if input % 4 else 1) * (1 if input % 100 else 0 + 0 if input % 400 else 1))