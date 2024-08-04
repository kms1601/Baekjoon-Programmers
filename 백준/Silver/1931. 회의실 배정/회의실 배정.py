import sys

input = sys.stdin.readline
timetables = []
for _ in range(int(input())):
    timetables.append(list(map(int, input().split())))
timetables.sort(key=lambda x: (x[1], x[0]))

using = timetables[0]
used = 1
for timetable in timetables[1:]:
    if timetable[0] >= using[1]:
        using = timetable
        used += 1
print(used)
