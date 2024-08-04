exp = input()

idx = 0
is_open = True
while idx < len(exp):
    if exp[idx] == "-":
        if is_open:
            exp = exp[: idx + 1] + "(" + exp[idx + 1 :]
            is_open = False
        else:
            exp = exp[:idx] + ")" + exp[idx:]
            is_open = True
    if exp[idx] == "0":
        if idx == 0 or exp[idx - 1] in ["+", "-", "("]:
            exp = exp[:idx] + exp[idx + 1 :]
        else:
            idx += 1
    else:
        idx += 1
if not is_open:
    exp += ")"
print(eval(exp))
