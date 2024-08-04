num = int(input())
title_list = []

for i in range(666, 2666800):
    if '666' in str(i):
        title_list.append(i)
print(sorted(title_list)[num-1])