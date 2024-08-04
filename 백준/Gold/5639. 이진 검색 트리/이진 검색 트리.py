import sys

sys.setrecursionlimit(100000)
def post(left, right):
    if left >= right:
        return
    
    split = right
    for i in range(left + 1, right):
        if tree[left] < tree[i]:
            split = i
            break
    
    post(left + 1, split)
    post(split, right)
    print(tree[left])

tree = []

while True:
    try:
        tree.append(int(input()))
    except EOFError:
        break
post(0, len(tree))