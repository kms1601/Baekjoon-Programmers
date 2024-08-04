def pow(a, b):
    if b == 0:
        return 1
    
    temp = pow(a, b // 2)
    
    if b % 2 == 0:
        return temp * temp % C
    else:
        return temp * temp * a % C

A, B, C = map(int, input().split())

print(pow(A, B) % C)