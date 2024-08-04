def forward(node):
    if not node in tree.keys():
        return
    print(tree[node], end='')
    forward(node * 2)
    forward(node * 2 + 1)

def middle(node):
    if not node in tree.keys():
        return
    middle(node * 2)
    print(tree[node], end='')
    middle(node * 2 + 1)

def backward(node):
    if not node in tree.keys():
        return
    backward(node * 2)
    backward(node * 2 + 1)
    print(tree[node], end='')

tree = {1: 'A'}
tree_rev = {'A': 1}

N = int(input())
for _ in range(N):
    p, l, r = input().split()
    
    if l != '.':
        tree[tree_rev[p] * 2] = l
        tree_rev[l] = tree_rev[p] * 2
        
    if r != '.':
        tree[tree_rev[p] * 2 + 1] = r
        tree_rev[r] = tree_rev[p] * 2 + 1

forward(1)
print()
middle(1)
print()
backward(1)