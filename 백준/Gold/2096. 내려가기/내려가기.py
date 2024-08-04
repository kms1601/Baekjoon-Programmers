import sys

input = sys.stdin.readline
N = int(input())
score = []
max_score = [0, 0, 0]
min_score = [0, 0, 0]

for _ in range(N):
    score = list(map(int, input().split()))

    l1, m1, r1 = score
    l2, m2, r2 = max_score
    max_score[0] = max([l2, m2]) + l1
    max_score[1] = max([l2, m2, r2]) + m1
    max_score[2] = max([m2, r2]) + r1

    l2, m2, r2 = min_score
    min_score[0] = min([l2, m2]) + l1
    min_score[1] = min([l2, m2, r2]) + m1
    min_score[2] = min([m2, r2]) + r1

print(max(max_score), min(min_score))
