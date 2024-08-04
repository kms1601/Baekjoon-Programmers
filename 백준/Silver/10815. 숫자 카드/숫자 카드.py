from collections import defaultdict

N = int(input())
inp1 = list(map(int, input().split()))
deck = defaultdict(int)

for card in inp1:
    deck[card] = 1
M = int(input())

inp2 = list(map(int, input().split()))

for card in inp2:
    if deck[card]:
        print(1, end=' ')
    else:
        print(0, end=' ')

