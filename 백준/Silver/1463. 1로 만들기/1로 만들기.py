inp = int(input())
cnt_list = [1, 0, 1, 1]

if inp not in [1, 2, 3]:
    for num in range(4, inp + 1):
        tmp = []
        if num % 3 == 0:
            tmp.append(cnt_list[int(num / 3)] + 1)
        if num % 2 == 0:
            tmp.append(cnt_list[int(num / 2)] + 1)
        tmp.append(cnt_list[num - 1] + 1)
        cnt_list.append(sorted(tmp)[0])
if inp == 1:
    print(0)
else:
    print(cnt_list[-1])
