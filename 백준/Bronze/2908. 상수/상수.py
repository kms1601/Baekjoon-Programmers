numbers = input().split()

for idx, number in enumerate(numbers):
    numbers[idx] = int(number[::-1])

print(max(numbers))