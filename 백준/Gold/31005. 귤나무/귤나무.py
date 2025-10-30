import sys

input = sys.stdin.readline


def remove_bears(bears: list, count: int) -> (int, list):
    new = []
    for bear in bears:
        if bear <= count:
            count -= bear
            new.append(bear)
    return count, new


def main():
    N, M = map(int, input().split())
    bears = list(map(int, input().split()))

    while len(bears):
        _sum = sum(bears)
        M %= _sum
        M, bears = remove_bears(bears, M)
    print(M)


if __name__ == "__main__":
    main()
