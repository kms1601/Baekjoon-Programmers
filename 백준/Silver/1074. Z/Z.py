import sys

RTCT = [[0, 1],[2, 3]]
n, r, c = map(int, sys.stdin.readline().split())
first = 0

for i in range(n)[::-1]:
    rt = r
    ct = c
    rt //= 2 ** i
    ct //= 2 ** i
    first += (4 ** i) * RTCT[rt][ct]
    r -= rt * (2 ** i)
    c -= ct * (2 ** i)
print(first)