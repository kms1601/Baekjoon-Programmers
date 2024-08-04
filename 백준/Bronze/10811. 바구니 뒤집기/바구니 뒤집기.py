import sys

M, N = map(int, sys.stdin.readline().split())
basket = [i + 1 for i in range(M)]
for _ in range(N):
    start, end = map(int, sys.stdin.readline().split())
    change = basket[start - 1:end]
    change.reverse()
    basket = basket[0:start - 1] + change + basket[end:M]
for i in basket:
    print(i, end = ' ')