import sys

while True:
    line = sys.stdin.readline()

    if line == ".\n":
        break

    stack = []
    result = "yes"

    for char in line:
        if char in ["(", "["]:
            stack.append(char)
        elif char == ")":
            if not stack or stack.pop() != "(":
                result = "no"
                break
        elif char == "]":
            if not stack or stack.pop() != "[":
                result = "no"
                break
    if stack:
        result = "no"
        
    print(result)
