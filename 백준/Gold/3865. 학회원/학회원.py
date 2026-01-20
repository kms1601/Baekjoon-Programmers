import sys

input = sys.stdin.readline


def parse_input(s):
    ins, names = s.split(":")
    name_set = set(names.split(","))
    return ins, name_set


def get_count(institutes, ins, result, visited):
    if ins in visited:
        return
    
    visited.add(ins)
    names = institutes[ins]
    for name in names:
        if name in institutes:
            get_count(institutes, name, result, visited)
        else:
            result.add(name)


while True:
    n = int(input())
    if n == 0:
        break
    
    institutes = {}
    
    institute, name_set = parse_input(input()[:-2])
    institutes[institute] = name_set
    target = institute
    for _ in range(n - 1):
        line = input().strip()
    
        institute, name_set = parse_input(line[:-1])
        institutes[institute] = name_set
    
    count = set()
    visited = set()
    get_count(institutes, target, count, visited)
    print(len(count))
        