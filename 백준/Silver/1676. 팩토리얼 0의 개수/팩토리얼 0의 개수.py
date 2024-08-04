num = int(input())
five = 0

while num:
    tmp = num
    while tmp % 5 == 0:
        five += 1
        tmp /= 5
    num -= 1

print(five)