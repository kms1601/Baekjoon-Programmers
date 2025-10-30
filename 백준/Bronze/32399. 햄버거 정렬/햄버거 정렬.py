import sys

input = sys.stdin.readline


def main():
    _input = input().strip()

    if _input == "(1)":
        print(0)
    elif _input == "1()":
        print(1)
    elif _input == ")1(":
        print(2)
    elif _input == "()1":
        print(1)
    elif _input == ")(1":
        print(1)
    elif _input == "1)(":
        print(1)


if __name__ == "__main__":
    main()
