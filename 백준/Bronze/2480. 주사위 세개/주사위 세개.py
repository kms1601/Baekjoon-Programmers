import sys

a, b, c = map(int, sys.stdin.readline().split())
if a == b and b == c:
    print(10000 + a * 1000)
elif a == b or b == c or a == c:
    print(1000 + 100 * (a * int(a == b) + b * int(b == c) + c * int(a == c)))
else:
    print(100 * max([a, b, c]))