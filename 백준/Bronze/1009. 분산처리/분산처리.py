for _ in range(int(input())):
    first = []
    a, b = map(int, input().split())
    tmp = a % 10
    
    while len(first) < 2 or first[0] != first[-1]:
        first.append(tmp)
        tmp = (tmp * a) % 10
    answer = first[:-1][b % (len(first) - 1) - 1]
    print(10 if answer == 0 else answer)