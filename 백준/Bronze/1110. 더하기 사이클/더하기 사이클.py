def oper(num):
    if len(num) == 1:
        num = "0" + num
    sum_ = str(sum(map(int, list(num))))
    first = sum_[::-1][0]
    second = num[1]
    return second + first if second != "0" else first


n = input()
new = oper(n)
cycle = 1
while n != new:
    new = oper(new)
    cycle += 1
print(cycle)
