from math import ceil

a, b, v = map(int, input().split())

v -= a
print(ceil(v / (a - b)) + 1)
