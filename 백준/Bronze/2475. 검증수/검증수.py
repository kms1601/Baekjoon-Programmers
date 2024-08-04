serial_no = input().split()
ver = 0

for n in serial_no:
    ver += int(n) ** 2

print(ver % 10)
