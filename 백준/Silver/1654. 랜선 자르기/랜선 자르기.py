import sys


lan_list = []


def get_lan_cnt(length):
    result = 0
    for lan in lan_list:
        result += lan // length
    return result


input = sys.stdin.readline
k, n = map(int, input().split())
answer = 0

for _ in range(k):
    lan_list.append(int(input()))

left, right = 1, max(lan_list) + 1

while left <= right:
    mid = (left + right) // 2
    cnt = get_lan_cnt(mid)

    if cnt < n:
        right = mid - 1
    elif cnt >= n:
        answer = mid
        left = mid + 1
print(answer)
