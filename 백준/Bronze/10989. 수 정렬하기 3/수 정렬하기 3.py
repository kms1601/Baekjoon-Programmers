import sys

num_list = [0] * 10000
for _ in range(int(sys.stdin.readline())):
    num_list[int(sys.stdin.readline()) - 1] += 1

for i in range(10000):
    while num_list[i]:
        print(i + 1)
        num_list[i] -= 1
