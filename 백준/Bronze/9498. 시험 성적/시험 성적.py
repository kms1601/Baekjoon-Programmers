import sys

input = int(sys.stdin.readline())
print('A' if input >= 90 else 'B' if input >= 80 else 'C' if input >= 70 else 'D' if input >= 60 else 'F')