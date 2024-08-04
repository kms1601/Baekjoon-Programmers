import sys

x = int(sys.stdin.readline())
y = int(sys.stdin.readline())
print(1 if x > 0 and y > 0 else 2 if x < 0 and y > 0 else 3 if x < 0 and y < 0 else 4)