import math

target = int(input())
breakdown = int(input())
click = []

if 0 < breakdown <= 10:
    breakdown_list = sorted(input().split())
else:
    breakdown_list = []

click.append(abs(target - 100))

tmp1 = target
if breakdown_list != ["1", "2", "3", "4", "5", "6", "7", "8", "9"]:
    while breakdown - 10:
        tmp2 = tmp1
        for i in str(tmp1):
            if i in breakdown_list:
                tmp1 += 1
                break
        if tmp2 == tmp1:
            break
if breakdown - 10 and breakdown_list != ["1", "2", "3", "4", "5", "6", "7", "8", "9"]:
    click.append(tmp1 - target + int(math.log10(tmp1) if tmp1 > 0 else 0) + 1)

tmp1 = target
while breakdown - 10:
    tmp2 = tmp1
    for i in str(tmp1):
        if i in breakdown_list:
            tmp1 -= 1
            break
    if tmp2 == tmp1:
        break
if breakdown - 10:
    click.append(target - tmp1 + int(math.log10(tmp1) if tmp1 > 0 else 0) + 1)
print(min(click))
