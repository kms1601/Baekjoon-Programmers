for _ in range(int(input())):
    zero = 1
    one = 0
    num = int(input())
    
    while num:
        tmp = zero
        zero = one
        one += tmp
        num -= 1
    print(zero, one)