N = int(input())
P = int(input())
discount = [P]

if N >= 20:
    discount.append(P * 0.75)
elif N >= 10:
    discount.append(P * 0.9)

if N >= 15:
    discount.append(P - 2000 if P - 2000 >= 0 else 0)
elif N >= 5:
    discount.append(P - 500 if P - 500 >= 0 else 0)

print(int(min(discount)))
