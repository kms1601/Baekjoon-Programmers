target = int(input())
sticks = [64]

while target < sum(sticks):
    sticks.sort(reverse=True)
    shortest = sticks.pop()
    cut = shortest / 2
    
    sticks.append(cut)
    if sum(sticks) < target:
        sticks.append(cut)

print(len(sticks))