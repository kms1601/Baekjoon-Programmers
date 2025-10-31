import sys

input = sys.stdin.readline
result = 0


def dfs(nodes: list[list], cur: int) -> None:
    global result
    node = nodes[cur]
    if len(node) == 0:
        result += 1
        return

    for n in node:
        dfs(nodes, n)


def main():
    N = int(input())
    _input = list(map(int, input().split()))
    delete = int(input())
    root = -1
    nodes = [[] for _ in range(N)]
    for i, parent in enumerate(_input):
        if i == delete:
            continue

        if parent == -1:
            root = i
            continue

        nodes[parent].append(i)

    if root != -1:
        dfs(nodes, root)

    print(result)


if __name__ == '__main__':
    main()
