import re

n = int(input())
len_ = int(input())
str_ = input()
pn = ["I"]
for _ in range(n):
    pn.extend(["O", "I"])
pn = "".join(pn)
print(len(re.findall(f"(?=({pn}))", str_)))
