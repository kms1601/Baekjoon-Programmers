for _ in range(int(input())):
    tmp = []
    people = [i + 1 for i in range(14)]
    floor = int(input())
    num = int(input())
    
    for _ in range(floor):
        tmp = [sum(people[0:i + 1]) for i in range(14)]
        people = tmp.copy()
    print(people[num - 1])