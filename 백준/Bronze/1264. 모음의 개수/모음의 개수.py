while True:
    string = input().lower()
    cnt = 0
    
    if string == '#':
        break
    
    for cha in string:
        if cha in ['a', 'e', 'i', 'o', 'u']:
            cnt += 1
    print(cnt)