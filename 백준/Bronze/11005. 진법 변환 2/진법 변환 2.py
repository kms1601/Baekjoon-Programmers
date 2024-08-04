num, ari = map(int, input().split())
answer = []
num_str = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'

while num > 0:
    answer.append(num_str[num % ari])
    num //= ari
print(''.join(answer[::-1]))