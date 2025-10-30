import sys

OPERATIONS = ["+", "-", "*", "/", "=="]

input = sys.stdin.readline


def main():
    a, b, c = map(int, input().split())
    for x in OPERATIONS:
        for y in OPERATIONS:
            expr = f"{a}{x}{b}{y}{c}"
            if eval(expr) is True:
                print(expr.replace("==", "="))
                return


if __name__ == '__main__':
    main()
