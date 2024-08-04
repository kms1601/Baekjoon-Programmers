num = int(input())
cnt = 1
max_num = 1
while max_num < num:
    max_num += cnt * 6
    cnt += 1
print(cnt)