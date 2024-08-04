target = int(input())
bags5 = 0
bags3 = 0

for tmp3 in range(target // 3 + 1):
    target_tmp = target
    
    target_tmp -= tmp3 * 3
    
    if target_tmp % 5 == 0:
        bags5 = target_tmp // 5
        bags3 = tmp3
        break
summ = bags3 + bags5
print(summ if summ else -1)
