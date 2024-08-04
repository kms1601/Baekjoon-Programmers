import sys

n = int(sys.stdin.readline())

if n in [1, 2]:
    print(1)
elif n in [3, 4, 5]:
    print(2)
else:
    print(3)