import sys
from collections import defaultdict


input = sys.stdin.readline
answer = []
_ = int(input())
deck = list(map(int, input().split()))
dic = defaultdict(int)

for num in deck:
    dic[num] += 1

_ = int(input())

test = list(map(int, input().split()))

for num in test:
    answer.append(str(dic[num]))

print(" ".join(answer))
