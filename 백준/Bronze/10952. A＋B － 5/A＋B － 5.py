import sys

input = []
while True:
    a, b = map(int, sys.stdin.readline().split())
    if a == 0 and b == 0:
        break
    input.append([a, b])
for i in input:
    print(i[0] + i[1])