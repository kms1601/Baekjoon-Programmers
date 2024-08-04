import sys

input = sys.stdin.readline
n, m = map(int, input().split())
trees = list(map(int, input().split()))
left, right = 1, max(trees) - 1
answer = 0
while left <= right:
    mid = (left + right) // 2
    total = 0
    for tree in trees:
        if mid <= tree:
            total += tree - mid
    if total < m:
        right = mid - 1
    elif total >= m:
        answer = mid
        left = mid + 1
print(answer)
