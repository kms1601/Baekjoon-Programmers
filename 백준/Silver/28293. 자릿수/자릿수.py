import sys, math

a, b = map(int, sys.stdin.readline().split())
print(math.floor(b * math.log10(a) + 1))