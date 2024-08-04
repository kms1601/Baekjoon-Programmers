from math import ceil

a, b, c = map(int, input().split())
try:
    profit = a / (c - b)
    if profit < 0:
        print(-1)
    elif profit.is_integer():
        print(int(profit + 1))
    else:
        print(ceil(profit))
except ZeroDivisionError:
    print(-1)
