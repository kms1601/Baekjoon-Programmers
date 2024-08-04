A, B, N = map(int, input().split())
answer = 0

if B != 1:
    while A >= B:
        A %= B
    A *= 10
    
    for i in range(N):
        if A >= B:
            answer= A // B
            A %= B
            A *= 10
        else:
            A *= 10
            answer = 0
print(answer)

