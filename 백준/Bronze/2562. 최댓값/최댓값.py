import sys

num = 0
index = 0
for i in range(9):
    input = int(sys.stdin.readline())
    if num < input:
        num = input
        index = i
print(num)
print(index + 1)