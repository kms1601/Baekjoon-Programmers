import statistics
import sys

num_cnt = int(input())
num_list = []

for _ in range(num_cnt):
    num_list.append(int(sys.stdin.readline()))
num_list.sort()

print(round(statistics.mean(num_list)))
print(statistics.median(num_list))

mode = statistics.multimode(num_list)
if len(mode) == 1:
    print(mode[0])
else:
    print(mode[1])
print(max(num_list) - min(num_list))
