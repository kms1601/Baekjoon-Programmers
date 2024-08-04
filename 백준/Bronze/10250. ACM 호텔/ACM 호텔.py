for _ in range(int(input())):
    h, w, n = map(int, input().split())

    if n % h == 0:
        floor = str(h)
    else:
        floor = str(n % h)
    
    room = str((n - 1) // h + 1)
    
    if len(room) == 1:
        room = '0' + room
        
    print(floor + room)