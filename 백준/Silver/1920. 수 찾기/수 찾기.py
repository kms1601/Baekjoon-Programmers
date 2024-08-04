num1 = int(input())
num_list = map(int, input().split())
dic = {}

for n in num_list:
    dic[n] = 1

num2 = int(input())
num_list = map(int, input().split())

for m in num_list:
    if m in dic:
        print(1)
    else:
        print(0)