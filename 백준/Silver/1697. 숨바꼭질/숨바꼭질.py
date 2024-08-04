from collections import deque

subin, sister = map(int, input().split())
time_list = [-1] * 200001
queue = deque([subin])
time_list[subin] = 0

while queue:
    pos = queue.popleft()
    if pos == sister:
        print(time_list[pos])
    else:
        if pos <= 100000 and time_list[pos * 2] == -1:
            time_list[pos * 2] = time_list[pos] + 1
            queue.append(pos * 2)
        if pos <= 100000 and time_list[pos + 1] == -1:
            time_list[pos + 1] = time_list[pos] + 1
            queue.append(pos + 1)
        if pos > 0 and time_list[pos - 1] == -1:
            time_list[pos - 1] = time_list[pos] + 1
            queue.append(pos - 1)
