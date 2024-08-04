def is_prime(num):
    if num == 1:
        return False
    for i in range(2, int(num ** 0.5 + 1)):
        if num % i == 0:
            return False
    return True

_ = int(input())
answer = 0

for num in map(int, input().split()):
    if is_prime(num):
        answer += 1
print(answer)