import sys
from math import factorial

for i in range(int(sys.stdin.readline())):
    n, m = map(int, sys.stdin.readline().split())
    print(int(factorial(m) / (factorial(m - n) * factorial(n))))
