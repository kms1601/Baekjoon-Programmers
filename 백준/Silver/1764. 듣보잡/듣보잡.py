import sys
from collections import defaultdict

input = sys.stdin.readline
n, m = map(int, input().split())
d = defaultdict(int)
db = []

for _ in range(n):
    d[input().strip()] = 1
for _ in range(m):
    name = input().strip()
    if d[name]:
        db.append(name)

print(len(db))
for name in sorted(db):
    print(name)
