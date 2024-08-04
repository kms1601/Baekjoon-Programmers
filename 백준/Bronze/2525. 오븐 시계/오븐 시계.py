import sys

time = list(map(int, sys.stdin.readline().split()))
when = int(sys.stdin.readline())
print(time[0] + ((time[1] + when) // 60) if time[0] + ((time[1] + when) // 60) < 24 else time[0] + ((time[1] + when) // 60) - 24, (time[1] + when) % 60)