def is_prime(num):
    for i in range(3, int(num ** 0.5 + 1)):
        if num % i == 0:
            return
    print(num)
    return

m, n = map(int, input().split())

if m <= 2:
    print(2)
    if m == 1:
        m += 2
    else:
        m += 1
if m % 2 == 0:
    m += 1

for num in range(m, n + 1, 2):
    is_prime(num)