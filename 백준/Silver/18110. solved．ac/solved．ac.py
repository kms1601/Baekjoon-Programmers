import sys


def round(num):
    numint = int(num)
    num -= numint

    if num >= 0.5:
        return numint + 1
    else:
        return numint


level_list = []

for _ in range(int(sys.stdin.readline())):
    level_list.append(int(sys.stdin.readline()))

if not level_list:
    level_list.append(0)

level_list = sorted(level_list)[
    round(len(level_list) * 0.15) : len(level_list) - round(len(level_list) * 0.15)
]
print(round(sum(level_list) / len(level_list)))
