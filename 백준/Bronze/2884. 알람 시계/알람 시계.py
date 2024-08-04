import sys

time = list(map(int, sys.stdin.readline().split()))
print(time[0] if time[1] >= 45 else time[0] - 1 if time[0] > 0 else 23, time[1] - 45 if time[1] >=45 else time[1] + 15)