import sys

input = sys.stdin.readline
members = []

for _ in range(int(input())):
    members.append(input().split())

members = sorted(members, key=lambda x: int(x[0]))

for age, name in members:
    print(age, name)
