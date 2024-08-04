import sys

a = list(map(int, sys.stdin.readline().split()))
print(f'{(a[0] + a[1]) % a[2]}\n{((a[0] % a[2]) + (a[1] % a[2])) % a[2]}\n{(a[0] * a[1]) % a[2]}\n{((a[0] % a[2]) * (a[1] % a[2])) % a[2]}')