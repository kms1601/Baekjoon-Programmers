dic = {'0': 0, '1': 0, '2': 0, '3': 0, '4': 0, '5': 0, '6': 0, '7': 0, '8': 0, '9': 0, }
a, b, c = int(input()), int(input()), int(input())
mul = str(a * b * c)

for num in mul:
    dic[num] += 1

for i in range(10):
    print(dic[str(i)])
