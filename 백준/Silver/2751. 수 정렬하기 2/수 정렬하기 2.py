import sys

input = sys.stdin.readline

num_list = []

for _ in range(int(input())):
    num_list.append(int(input()))
num_list.sort()

for num in num_list:
    print(num)
