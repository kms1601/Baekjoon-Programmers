def get_decom(num):
    result = num
    
    for digit in str(num):
        result += int(digit)
    return result

decom = int(input())
answer = 0

for num in range(1, decom + 1):
    if decom == get_decom(num):
        answer =num
        break
print(answer)
