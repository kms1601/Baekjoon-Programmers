import sys

ground = []
time_list = []
n, m, b = map(int, sys.stdin.readline().split())

for _ in range(n):
    line = map(int, sys.stdin.readline().split())
    
    for block in line:
        ground.append(block)
    
for height in range(257):
    b_tmp = b
    time = 0
    
    for block in ground:
        if height < block:
            time += 2 * (block - height)
            b_tmp += block - height
        elif height > block:
            time += 1 * (height - block)
            b_tmp -= height - block
    if b_tmp >= 0:
        time_list.append([time, height])

time_list = sorted(time_list, key=lambda x: (x[0], -x[1]))
print(*time_list[0])