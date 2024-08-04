import sys

input = []
while True:
    try:
        a, b = map(int, sys.stdin.readline().split())
    except:
        break
    input.append([a, b])
    
for i in input:
    print(i[0] + i[1])