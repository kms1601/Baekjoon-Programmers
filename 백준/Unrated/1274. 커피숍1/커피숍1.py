a, b = map(int, input().split())
vol_a, vol_b, cup = map(int, input().split())
drink = 0
density = a

while vol_a >= cup and drink <= 50:
    if density <= a:
        drink += 1
        density = a
    else:
        break
    
    if vol_b < cup:
        break
    else:
        a = ((vol_a-cup)*a + b*cup)/vol_a
        b = ((vol_b-cup)*b)/vol_b

if 0 < drink <= 50:
    print(str('%x'%drink).upper())
else:
    print('gg')