import sys

input = sys.stdin.readline
for _ in range(int(input())):
    pass_ = 0
    score = list(map(int, input().split()[1:]))
    mean = sum(score) / len(score)
    for sco in score:
        if sco > mean:
            pass_ += 1
    ratio = round(pass_ / len(score) * 100, 3)
    print("%.3f" % ratio, "%", sep="")
