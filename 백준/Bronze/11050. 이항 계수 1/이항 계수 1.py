from math import factorial as fac

N, K = map(int, input().split())
print(int(fac(N) / (fac(K) * fac(N - K))))