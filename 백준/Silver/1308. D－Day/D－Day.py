from datetime import datetime

start = list(map(int, input().split()))
end = list(map(int, input().split()))

start = datetime(start[0], start[1], start[2])
end = datetime(end[0], end[1], end[2])
duration = (end - start).days

if duration > 365242:
    print('gg')
else:
    print(f'D-{duration}')
