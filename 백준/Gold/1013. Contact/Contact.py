import re
import sys

input = sys.stdin.readline


def main():
    N = int(input())
    p = re.compile("(100+1+|01)+")
    for _ in range(N):
        if p.fullmatch(input().strip()):
            print("YES")
        else:
            print("NO")


if __name__ == '__main__':
    main()
