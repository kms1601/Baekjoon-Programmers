num = int(input())
paper = []
black = set()

for _ in range(num):
    paper.append(map(int, input().split()))

for x, y in paper:
    for i in range(10):
        for j in range(10):
            black.add((x + i, y + j))
print(len(black))