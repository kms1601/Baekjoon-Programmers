ppap = input()
stack = []

for c in ppap:
    if c == "P":
        if len(stack) >= 3 and "".join(stack[-3:]) == "PPA":
            stack.pop()
            stack.pop()
            stack.pop()
            stack.append("P")
        else:
            stack.append(c)
    else:
        stack.append(c)

if ppap == "P":
    print("PPAP")         
elif len(stack) > 1 or len(ppap) < 4:
    print("NP")
else:
    print("PPAP")