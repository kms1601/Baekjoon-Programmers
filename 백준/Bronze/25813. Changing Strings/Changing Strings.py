import sys

input = sys.stdin.readline


def main():
    string = input().strip()
    len_ = len(string)
    leftmost = 0
    rightmost = 0
    for i in range(len_):
        if string[i] == "U":
            leftmost = i
            break
    
    for i in range(len_):
        if string[len_ - i - 1] == "F":
            rightmost = i
            break
    
    print("-" * leftmost + "U" + "C" * (len_ - rightmost - leftmost - 2) + "F" + "-" * rightmost)
    

if __name__ == "__main__":
    main()